Follow up Questions:

Is this system is widely available ? In all world
Is this system should store the address in English only or any language
For any address, do we need to store the building information, road information etc in form on image (like google does)
Do we need to address any point in Sea?
Or this system should address, addresses in the city?
Is finding the current region is City/forest/sea etc is out of scope?
We can find out the requirement accordingly, this may change the algorithm of uniquely identifying address drastically.

I'm assuming, least of them and considering we need to address, addresses on Sea point too (so that it can be use for some crucial purposes)

System Requirement:
Functional

Any address can be map to our system(whole earth)
Each address should be uniquely identified
User can search the address
Non-functional
The address should be consistent- once a uniquely identified can be identified with the same key again - Consistency
Since Data is very huge (500 million Km^2 earth size) then we need to partition this data across - Partition tolerance
Latency should be low for finding any address (low latency -100 to 400 ms )
System can be somewhat available as it won't much affect if some user won't be able to use system for a few seconds [but only for 10-15 seconds max and should happen very rarely - maintenance ]
The last point is debatable but since we need consistency for sure then we need to compromise the availability. That can be discussed with interviewer.

Capacity calculation

Earth is of nearly 500 million KM^2 in size which is 5 * 10^8 (KM)^2. Let's assume we divide the big square in small number of tiny square so that we can map each of them.
How short or long Is depend on how granular level of address we are supporting. If we support least one like Street address then we need to be very sure that square should be minimum like 5m x 5 m

Lets make it more granular with 3m X 3m
Now each 1km = 1000 m
so there will be 333m blocks of size 3m in a KM.
hence 1000m * 1000 m => 333m * 333m

If we need to store only address?
Let's assume that each address take up to 100 character (100 bytes) at max including pin codes etc.

Lets assume each 3mx3m block have a single address then
111 * ( 3mx3m) = 111 * 100 bytes = 11,100 bytes = 11 MB =>
so for storing 1 * (KM)^2 we need 11 MB
so for 500 million (KM)^2 we need = 500 million * 11 MB = 5500 million MB = 5500 GB ( 1million*1MB = 1 GB) = 5.5 TB

Data is reasonable in size 5.5 TB for whole world map.
Assuming a machine that can hold 15 TB than 1 node.
But storing whole data on 1 node would not be great idea. So assume on each node we store up to 100 GB makes this make our query bit faster
5500 / 100 = **55 Nodes **

If we need to store images.[Point 3]
Lets assume, that each of this block consume 1 MB (which include minimal contextual information too such as 1 building, 2 road name etc)

Size would be in MB : 1000m * 1000 m => 333m * 333m and each of 1MB => 333MB *333MB = 110889 MB lets make it 111000MB =111 GB

so for storing 1 * (KM)^2 we need 111 GB
so for 500 million (KM)^2 we need = 500 million * 111 GB =55500 million GB = 55500 PB { since 1 million * 1 GB = 1 PB)
55500 PB => 55.5 XB

Data is so huge 55.5 XB for whole world map.

Assuming a machine that can hold 15 TB than 3.7 million nodes. That so huge.
So we need to vertical scale it.

A 64 bit machine can hold up to 16XB of data "theoretically"
232 = 4 GB (4109 bytes), therefore
264 = (4109)2 = 161018 bytes = 16106 TBs = 16000 PBs = 16 EBs (Exabytes)

But that will be very costly, so lets settle down to somewhere 100 TB of size. Nodes require = 5,55,000 (~0.5 million)
[We need to have big size machines otherwise we need to have so many nodes, that makes our query bit slow but we need to find a way to solve it]

Since we need make data available all the time then assuming With 3 replace = 555000 * 3 = 1665000 = ~1.6 million nodes

Moving ahead, **managing 55 nodes is reasonably fine [ but not 1.6 million nodes ] **

Now let's dive into some system design.

Lets our system only store address and refer address using English language only.
The idea is we need to use engine words to identify address uniquely.

Ok, lets revise how many square we had
500 * 10^6 * km^2 = 500*10^6 * 110889 = 55444500 * 10^6 = 55 * 10^12 = 55 Trillion [ including Sea]
If we don't include sea and not useful area like forest, then we left with 10% of actual i.e. 50 million km^2
Hence 5.5 Trillion

We need to uniquely identify **55 trillion combination. **

English has ~60 K words, if we remove abusing, offensive and other bad words. Then we have up to 40K words. Since we have 3m x 3m square of blocks, we'll use 3 words to identify a address uniquely

so we have 40k^3 = 64 Trillion ( > 55 trillion > 5.5 Trillion )
Hence using 40K words, we can easily identify all the world address.
**We have (word1 x word2 x word3 ) 40k combination **

Now how we can map this uniquely ?
Three important points

We need to map Lat Long using 3 words.
Mapping this words to a square should be efficient
So square 0 can be identify with (word0 x word0 x word0), square 1 with (word0 x word0 x word1).....
as

Offline algorithm
We can pre-compute all the address and give them a unique combination as state above. Whenever some one wants to map a address, we can locate the Lat Long, and fetch from our pre-compute unique address and map it to given address;
Hence
**User address = (Lat Long) => (word m * word n * word o) **

How can we identify a region is City or not?

Using deep-learning algorithm to extract the road pixels from satellite images. Then an algorithm to connected the pixels together into a road network. The system analyzed the density and shape of the roads to segment the network into different communities, and the densest cluster was labeled as the city center. The regions around the city center were divided into north, south, east, and west quadrants, and streets were numbered and lettered according to their orientation and distance from the center.

**System Desing Components **

We need a client app that gives the flexibility to store a address ( app/web-app any thing)
Load Balancer : We need a elastic load balancer that distribute the load by region first then servers.
Mapper services : This service responsible to map the given address to a address that our system understand
Assigner Services [ Writer services ]
Block identifier services: Mapper service will call the block identifier services in order to find the block (3m x 3m) from Lat Long [ can be from cache or DB ]
Block Assigner services: This service will be invoked and use to assign the above block to user address.
Writer services: This service take the request form Block assigner services and store the information to Database and write a copy in our cache.
Reader services
Use Block identifier reader service: This will take our unique address from user and hit the cache to get the cached data or from Database
Cache: Store the frequent searches ( LRU). We can use Memcache here as we need to retrieve whole blob in one short, Or we can Use Redis.
Database: SQL + MongoDB(for storing blocks and address ) + Cassandra (for logging and analysis) [ I did not put much thought on this ]
Offline: This is pipeline based Server [ Note I made this very easy but in real, that going to be very complex and concurrent. As doing one by one by take ages ]

Block finder services : Find a block of 3m x 3m which is unassigned
Word combination find services : This will find a valid un-used word combination
Block assigner services : This services will assign the above block to this word combination
Writer services : This service write this combination to Database/Cache