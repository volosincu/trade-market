

 # trade-market
 
 <h2> Frontend</h2>
 <p> The frontend component is in a separate project located <a href="https://github.com/volosincu/trade-market-ui.github.io"> here </a>.</p>


 <hr />
 <br />
 
 <h2> Backend</h2>
 <p>This application is a java web application that exposes an REST API for processing trade market messages.</p>
 

 <p>A short list of some implementation details :</p>
 <ul>
     <li> - authorization and authentication with Spring Security (Basic Authentication)</li>
     <li> - Validation </li>
     <li>
           <div>
                    <ul>
                        <li> - input must be a valid <code>JSON</code></li>
                        <li> - all fields are required </li>
                        <li> - type checking on fields </li>
                        <li> - the exchange amountBuy must match the product (amountSell * rate) </li>
                        <li> *<code> used RoundingMode.HALF_UP for(amountSell * rate) and amountBuy </code></li>
                    </ul>
            </div>
     </li>
     <li> </li>
 </ul>


 <br />
 <hr />`
 <br />
 
 
<h3>The endpoints : </h3>

<table>
    <thead>
        <tr>
            <td>endpoint name </td>
            <td>http method</td>
            <td>authentication required</td>
        </tr>
    </thead>
    <tbody>
        <tr>  
            <td><code> /messages </code></td>
            <td><code> post </code> </td>
            <td>(yes)</td>
        </tr>

        <tr>
            <td><code> /messages?gte={timestamp} </code></td>
            <td><code>  get </code>  </td>
            <td>(no)</td>
        </tr>

        <tr>
            <td> <code> /users/{userId}/messages </code> </td>
            <td><code> get </code> </td>
            <td>(no)</td>
        </tr>
    </tbody>
</table>



 <br />
 <hr />
 <br />
 




<code>

</code>


<code>

</code>

<code>


