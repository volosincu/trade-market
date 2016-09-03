<!DOCTYPE html>

<html>
 # trade-market
 
 <h2> Frontend</h2>
 <p> The frontend component is in a separate project located <a href="">here</a>.</p>

 <br />
 <hr />
 <br />
 
 <h2> Backend</h2>
 <p>This application is a java web application that exposes an REST API for processing trade market messages.</p>
 
 <br />
 <p>A short list of some implementation details :</p>
<br />

 <ul>
     <li> - authorization and authentication with Spring Security (Basic Authentication)</li>
     <li> - Validation </li>
     <li>
            <ul>
                <li> - input must be a valid <code>JSON</code></li>
                <li> - all fields are required </li>
                <li> - type checking on fields </li>
                <li> - the exchange amountBuy must match the product (amountSell * rate) </li>
                <li> *<code> used RoundingMode.HALF_UP for(amountSell * rate) and amountBuy </code></li>
            </ul>    
         
     </li>
 </ul>


 <br />
 <hr />
 <br />
 
 
<h3>The endpoints : </h3>

<table>
    <thead>
        <tr>
            <td>a</td>
            <td>b sdfds hbdshdgsdg</td>
            <td>c4324  234 5 5</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>aw123134345  54 </td>
            <td>bdsds</td>
            <td>dasasdasdasd</td>
        </tr>
    </tbody>
</table>



 <br />
 <hr />
 <br />
 
name  method authentication 
<code> /messages </code> <span> <code> post </code> (yes)</span> 
<code> /messages?gte={timestamp} </code> <span><code>  get </code> (no)</span>
<code> /users/messages/{userId} </code> <span> <code> get </code>(no)</span>




<code>

</code>


<code>

</code>

<code>

</code>
</html>
