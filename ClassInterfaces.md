# Introduction #

Class interfaces


# Details #

**1. Controller**

getDyingItems()截止日期

getLatestItems()刚post

getItemInfo(itemId)

login()

register(UserInfo userInfo)

requestPostItem()

submitItem()

confirmDelivery(itemId, receiptId)

confirmReceipt(itemId)

//???receipt password

getCatagories()

//???suicide

double curPrice requestBid(itemId)

boolean  offerPrice(double money, itemId)



boolean charge(double name, string userName)



**2. TimerManager**

boolean registerDeadline(itemId, Time)

void startUp()

void deadlineTrigger()


**3. ItemManager**

//createItem()

queryBiddedItems()

List

&lt;ItemDigest&gt;

 queryLatestItems()

List

&lt;ItemDigest&gt;

 queryDyingItems()



boolean addItem()

boolean updateDelivery(itemId, receiptId)

boolean updateReceipt(itemId)

Item queryItem(itemId)

double(curPrice) queryCurPrice(itemId)



double Money queryTransferPrice(userName, double offerMoney)

double Money transferPrice(userName, double offerMoney)

List<user, money> queryReturnMoney(itemId)


**4. CatagoryManager**

List

&lt;String&gt;

 queryCatagories()


**5. UserManager**

isValid(string user, string pass)

addUser(UserInfo userInfo)

charge(string userName, double money)

transfer(double money(+,-))


**6. Item**

info()


**7. ItemDigest**



**8. UserInfo**

setName()

……