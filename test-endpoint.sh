#!/bin/bash


echo ""
echo ""
echo "\n ==================================================================================================================================="
echo "   First let's  save valid transactions " 
echo ""
echo ""

 curl -u $1:$2  -H "Content-Type: application/json"  -X POST -d '{"userId": "9652455", "currencyFrom": "EUR", "currencyTo": "RON", "amountSell": 6450, "amountBuy": 29154, "rate": 4.52, "timePlaced" : "03-DEC-15 11:19:27", "originatingCountry" : "IE"}' $3
 curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "6584138", "currencyFrom": "EUR", "currencyTo": "RON", "amountSell": 6450, "amountBuy": 29154, "rate": 4.52, "timePlaced" : "04-DEC-15 11:19:27", "originatingCountry" : "UK"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "658111", "currencyFrom": "EUR", "currencyTo": "USD", "amountSell": 399, "amountBuy": 490.77, "rate": 1.23, "timePlaced" : "02-JUN-14 13:33:25", "originatingCountry" : "DE"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "86451316", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 22, "amountBuy": 57.2, "rate": 2.6, "timePlaced" : "01-SEP-14 02:21:02", "originatingCountry" : "RO"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "54646514", "currencyFrom": "USD", "currencyTo": "RON", "amountSell": 22, "amountBuy": 85.8, "rate": 3.9, "timePlaced" : "01-SEP-14 04:11:07", "originatingCountry" : "IE"}' $3
 curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "3545151231", "currencyFrom": "EUR", "currencyTo": "RON", "amountSell": 6450, "amountBuy": 29154, "rate": 4.52, "timePlaced" : "03-MAY-16 11:19:27", "originatingCountry" : "IE"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "6384531351", "currencyFrom": "EUR", "currencyTo": "DKK", "amountSell": 50, "amountBuy": 12.06, "rate": 0.2412, "timePlaced" : "07-MAY-16 13:10:21", "originatingCountry" : "RO"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "58522695", "currencyFrom": "CNY", "currencyTo": "JPY", "amountSell": 100, "amountBuy": 520, "rate": 5.2, "timePlaced" : "09-JUN-16 07:35:27", "originatingCountry" : "CN"}'  $3
 curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "58522695", "currencyFrom": "CNY", "currencyTo": "JPY", "amountSell": 100, "amountBuy": 520, "rate": 5.2, "timePlaced" : "11-JUN-16 07:35:27", "originatingCountry" : "CN"}'  $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "58522695", "currencyFrom": "CNY", "currencyTo": "JPY", "amountSell": 100, "amountBuy": 520, "rate": 5.2, "timePlaced" : "14-JUN-16 07:35:27", "originatingCountry" : "CN"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "58522695", "currencyFrom": "CNY", "currencyTo": "JPY", "amountSell": 100, "amountBuy": 520, "rate": 5.2, "timePlaced" : "18-JUN-16 07:35:27", "originatingCountry" : "CN"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "58522695", "currencyFrom": "CNY", "currencyTo": "JPY", "amountSell": 350, "amountBuy": 1820, "rate": 5.2, "timePlaced" : "18-JUN-16 12:35:27", "originatingCountry" : "CN"}'  $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "58522695", "currencyFrom": "CNY", "currencyTo": "JPY", "amountSell": 100, "amountBuy": 520, "rate": 5.2, "timePlaced" : "18-JUN-16 09:35:27", "originatingCountry" : "CN"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "2135113835", "currencyFrom": "EUR", "currencyTo": "RON", "amountSell": 9000, "amountBuy": 6723.9, "rate": 0.7471, "timePlaced" : "24-JUL-16 10:27:44", "originatingCountry" : "RO"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "5132130", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 100, "amountBuy": 560, "rate": 5.6, "timePlaced" : "10-AUG-16 05:21:02", "originatingCountry" : "RO"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "5132130", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 855, "amountBuy": 2223, "rate": 2.6, "timePlaced" : "16-AUG-16 06:29:02", "originatingCountry" : "IE"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "5132130", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 125, "amountBuy": 750, "rate": 6, "timePlaced" : "16-AUG-16 09:11:22", "originatingCountry" : "FR"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "5132130", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 154, "amountBuy": 400.4, "rate": 2.6, "timePlaced" : "18-AUG-16 11:31:02", "originatingCountry" : "RO"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "5132130", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 77, "amountBuy": 200.2, "rate": 2.6, "timePlaced" : "22-AUG-16 16:33:15", "originatingCountry" : "FR"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "5132130", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 256, "amountBuy": 665.6, "rate": 2.6, "timePlaced" : "01-SEP-16 02:21:02", "originatingCountry" : "RO"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "2333212", "currencyFrom": "USD", "currencyTo": "RON", "amountSell": 333, "amountBuy": 1298.7, "rate": 3.9,  "timePlaced" : "01-SEP-16 04:11:07", "originatingCountry" : "IE"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "5132130", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 77, "amountBuy": 200.2, "rate": 2.6, "timePlaced" : "30-AUG-16 18:33:15", "originatingCountry" : "FR"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "5132130", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 256, "amountBuy": 665.6, "rate": 2.6, "timePlaced" : "01-SEP-16 04:21:02", "originatingCountry" : "RO"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "2333212", "currencyFrom": "USD", "currencyTo": "RON", "amountSell": 333, "amountBuy": 1298.7, "rate": 3.9,  "timePlaced" : "01-SEP-16 07:11:07", "originatingCountry" : "IE"}' $3

 curl -u $1:$2  -H "Content-Type: application/json"  -X POST -d '{"userId": "9652455", "currencyFrom": "EUR", "currencyTo": "RON", "amountSell": 6450, "amountBuy": 29154, "rate": 4.52, "timePlaced" : "04-DEC-15 11:19:27", "originatingCountry" : "FR"}' $3
 curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "6584138", "currencyFrom": "EUR", "currencyTo": "RON", "amountSell": 6450, "amountBuy": 29154, "rate": 4.52, "timePlaced" : "05-DEC-15 11:19:27", "originatingCountry" : "UK"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "658111", "currencyFrom": "EUR", "currencyTo": "USD", "amountSell": 399, "amountBuy": 490.77, "rate": 1.23, "timePlaced" : "01-JUN-14 13:33:25", "originatingCountry" : "RO"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "86451316", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 22, "amountBuy": 57.2, "rate": 2.6, "timePlaced" : "02-SEP-14 02:21:02", "originatingCountry" : "RO"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "54646514", "currencyFrom": "USD", "currencyTo": "RON", "amountSell": 22, "amountBuy": 85.8, "rate": 3.9, "timePlaced" : "02-SEP-14 04:11:07", "originatingCountry" : "IE"}' $3
 curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "3545151231", "currencyFrom": "EUR", "currencyTo": "RON", "amountSell": 6450, "amountBuy": 29154, "rate": 4.52, "timePlaced" : "04-MAY-16 11:19:27", "originatingCountry" : "IE"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "6384531351", "currencyFrom": "EUR", "currencyTo": "DKK", "amountSell": 50, "amountBuy": 12.06, "rate": 0.2412, "timePlaced" : "08-MAY-16 13:10:21", "originatingCountry" : "RO"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "58522695", "currencyFrom": "CNY", "currencyTo": "JPY", "amountSell": 100, "amountBuy": 520, "rate": 5.2, "timePlaced" : "10-JUN-16 07:35:27", "originatingCountry" : "JP"}'  $3
 curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "58522695", "currencyFrom": "CNY", "currencyTo": "JPY", "amountSell": 100, "amountBuy": 520, "rate": 5.2, "timePlaced" : "12-JUN-16 07:35:27", "originatingCountry" : "JP"}'  $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "58522695", "currencyFrom": "CNY", "currencyTo": "JPY", "amountSell": 100, "amountBuy": 520, "rate": 5.2, "timePlaced" : "15-JUN-16 07:35:27", "originatingCountry" : "JP"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "58522695", "currencyFrom": "CNY", "currencyTo": "JPY", "amountSell": 100, "amountBuy": 520, "rate": 5.2, "timePlaced" : "18-JUN-16 07:59:27", "originatingCountry" : "CN"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "58522695", "currencyFrom": "CNY", "currencyTo": "JPY", "amountSell": 350, "amountBuy": 1820, "rate": 5.2, "timePlaced" : "18-JUN-16 12:00:27", "originatingCountry" : "CN"}'  $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "58522695", "currencyFrom": "CNY", "currencyTo": "JPY", "amountSell": 100, "amountBuy": 520, "rate": 5.2, "timePlaced" : "18-JUN-16 09:00:27", "originatingCountry" : "JP"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "2135113835", "currencyFrom": "EUR", "currencyTo": "RON", "amountSell": 9000, "amountBuy": 6723.9, "rate": 0.7471, "timePlaced" : "24-JUL-16 10:59:44", "originatingCountry" : "RO"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "5132130", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 100, "amountBuy": 560, "rate": 5.6, "timePlaced" : "10-AUG-16 08:21:02", "originatingCountry" : "RO"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "5132130", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 855, "amountBuy": 2223, "rate": 2.6, "timePlaced" : "17-AUG-16 06:29:02", "originatingCountry" : "IE"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "5132130", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 125, "amountBuy": 750, "rate": 6, "timePlaced" : "17-AUG-16 09:11:22", "originatingCountry" : "FR"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "5132130", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 154, "amountBuy": 400.4, "rate": 2.6, "timePlaced" : "19-AUG-16 11:31:02", "originatingCountry" : "RO"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "5132130", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 77, "amountBuy": 200.2, "rate": 2.6, "timePlaced" : "25-AUG-16 16:33:15", "originatingCountry" : "US"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "5132130", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 256, "amountBuy": 665.6, "rate": 2.6, "timePlaced" : "21-SEP-16 02:21:02", "originatingCountry" : "RO"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "2333212", "currencyFrom": "USD", "currencyTo": "RON", "amountSell": 333, "amountBuy": 1298.7, "rate": 3.9,  "timePlaced" : "21-SEP-16 04:11:07", "originatingCountry" : "IE"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "5132130", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 77, "amountBuy": 200.2, "rate": 2.6, "timePlaced" : "31-AUG-16 18:33:15", "originatingCountry" : "FR"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "5132130", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 256, "amountBuy": 665.6, "rate": 2.6, "timePlaced" : "11-SEP-16 04:21:02", "originatingCountry" : "UK"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "2333212", "currencyFrom": "USD", "currencyTo": "RON", "amountSell": 333, "amountBuy": 1298.7, "rate": 3.9,  "timePlaced" : "11-SEP-16 07:11:07", "originatingCountry" : "EG"}' $3


echo ""
echo ""
echo "\n ==================================================================================================================================="
echo "    Run Requests with bad exchange numbers  " 
echo ""
echo ""

curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "54313218", "currencyFrom": "EUR", "currencyTo": "DKK", "amountSell": 3, "amountBuy": 125, "rate": 0.2412, "timePlaced" : "14-MAY-14 13:17:21", "originatingCountry" : "IE"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "353138", "currencyFrom": "EUR", "currencyTo": "USD", "amountSell": 399, "amountBuy": 4555.77, "rate": 1.23, "timePlaced" : "02-JUN-16 13:33:25", "originatingCountry" : "DE"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "8855295", "currencyFrom": "USD", "currencyTo": "RON", "amountSell": 222, "amountBuy": 747.10, "rate": 0.7471, "timePlaced" : "02-SEP-16 14:11:07", "originatingCountry" : "US"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "684518315", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 1, "amountBuy": 165.8562, "rate": 0, "timePlaced" : "07-MAY-16 08:29:07", "originatingCountry" : "IE"}' $3
echo ""
echo ""
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "684518315", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 0, "amountBuy": 1, "rate": 0, "timePlaced" : "07-MAY-16 08:29:07", "originatingCountry" : "IE"}' $3
echo ""
echo "  :)  Warning !   Someone tried to stole one Euro here but he didn't make it !!!   :)  "
echo ""

echo ""
echo ""
echo "\n ==================================================================================================================================="
 echo ""
echo ""
echo "    Run Requests with negative numbers  " 
echo ""
echo ""

curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "86451316", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": -22, "amountBuy": 57.2, "rate": 2.6, "timePlaced" : "01-SEP-14 12:32:02", "originatingCountry" : "RO"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "6384531351", "currencyFrom": "EUR", "currencyTo": "DKK", "amountSell": -50, "amountBuy": 12.06, "rate": 0.2412, "timePlaced" : "17-MAY-16 13:10:21", "originatingCountry" : "RO"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "58522695", "currencyFrom": "CNY", "currencyTo": "JPY", "amountSell": -100, "amountBuy": 520, "rate": 5.2, "timePlaced" : "09-JUN-16 07:35:11", "originatingCountry" : "CN"}'  $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "58522695", "currencyFrom": "CNY", "currencyTo": "JPY", "amountSell": -100, "amountBuy": 520, "rate": 5.2, "timePlaced" : "18-JUN-16 07:11:27", "originatingCountry" : "CN"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "58522695", "currencyFrom": "CNY", "currencyTo": "JPY", "amountSell": 350, "amountBuy": -1820, "rate": 5.2, "timePlaced" : "18-JUN-16 12:58:27", "originatingCountry" : "CN"}'  $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "58522695", "currencyFrom": "CNY", "currencyTo": "JPY", "amountSell": 100, "amountBuy": 520, "rate": -5.2, "timePlaced" : "18-JUN-16 09:59:27", "originatingCountry" : "CN"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "2135113835", "currencyFrom": "EUR", "currencyTo": "RON", "amountSell": 9000, "amountBuy": -6723.9, "rate": -0.7471, "timePlaced" : "24-JUL-16 18:27:44", "originatingCountry" : "RO"}' $3

echo ""
echo ""
echo "\n ==================================================================================================================================="
echo ""
echo ""
echo "    Run Requests with invalid or missing data  " 
echo ""
echo ""

curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"": "", "": "", "": "", "": , "": 200.2, "rate": 2.6, "" : "22--16 ::15", "" : ""}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "5132130" "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 256, "amountBuy": 665.6, "rate": 2.6, "timePlaced" : "01-SEP-16 02:21:02", "originatingCountry" : "RO"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "5132130", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 256, "amountBuy": 665.6, "rate": 2.6, "timePlaced" : "01-SEP-16", "originatingCountry" : "RO"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "2333212" "currencyFrom": "USD", "currencyTo": "RON", "amountSell": 333, "amountBu298.7, "rate": 3.9,  "timePlaced" : "01-SEP-16 04:11:07", "originatingCountry" : "IE"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "5132130", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 256, "amountBuy": aaaaaaaa665.6, "rate": 2.6, "timePlaced" : "01-SEP-16 04:21:02", "originatingCountry" : "RO"}' $3
curl -u $1:$2 -H "Content-Type: application/json"  -X POST -d '{"userId": "2333212", "currencyFrom": "USD", "currencyTo": "RON", "amountSell": 333, "amountBuy": 1298.7, "rate": 3.9,  "timePlaced" : "01-SEP", "originatingCountry" : "IE"}' $3

echo ""
echo ""
echo "\n ==================================================================================================================================="
echo ""
echo ""
echo "    Try to acess an authorized resource  " 
echo ""
echo ""

curl  -H "Content-Type: application/json"  -X POST -d '{"userId": "5132130", "currencyFrom": "USD", "currencyTo": "EUR", "amountSell": 77, "amountBuy": 200.2, "rate": 2.6, "timePlaced" : "30-AUG-16 18:33:15", "originatingCountry" : "FR"}' $3
echo ""
curl -u $1:$2 -H "Content-Type: application/json"  -X GET -d '{"userId": "2333212", "currencyFrom": "USD", "currencyTo": "RON", "amountSell": 333, "amountBuy": 1298.7, "rate": 3.9,  "timePlaced" : "01-SEP-16 07:11:07", "originatingCountry" : "IE"}' $3

echo ""
echo ""
echo "\n ======================================================= THE END  ============================================================================"
echo ""
echo ""


