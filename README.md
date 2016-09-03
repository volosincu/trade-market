# trade-market 


<h4><a href="https://volosincu.github.io/trade-market-ui.github.io/#">link demo</a></h4>
 <p> !!!  Important   newer versions of browsers  block requests with <code>mixed content</code>. </p>
<p>Please disable this feature for viewieng the demo. (this is bcause frontend app his hosted on <code>github pages</code> and doesn't have have https enabled)</p>

<p>Chrome : <code>In the address bar at the right end should be a 'shield' icon, you can click on that to run insecure content.</code></p>
<p>Firefox : <code><a href="https://support.mozilla.org/en-US/kb/mixed-content-blocking-firefox#w_unblock-mixed-content"> how to disable mixed content </a></code></p>
 
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
                    <ul id="validation">
                        <li> - input must be a valid <code>JSON</code></li>
                        <li> - all fields are required </li>
                        <li> - type checking on fields </li>
                        <li> - the exchange amountBuy must match the product (amountSell * rate) </li>
                        <li> *<code> used RoundingMode.HALF_UP for(amountSell * rate) and amountBuy </code></li>
                    </ul>
            </div>
     </li>
     <li> - save data in mongoDB  (free hosting plan from mLab)</li>
     <li> 
         <div> 
             <ul  id="mongodb">
                 <li> <code>url</code> - <code> mongodb://currency:fair@ds021026.mlab.com:21026/icurrencyfair</code> </li>
             </ul>
         </div>
     </li>
     
     <li> - application hosted on Heroku (<code>currency-fair</code> branch deployed) </li>
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

<h5>Example : </h5>
<ul>
    <li><code><a href="http://icurrencyfair.herokuapp.com/messages">http://icurrencyfair.herokuapp.com/messages</a></code></li>
    <li><code><a href="http://icurrencyfair.herokuapp.com/messages?gte=1472307967043">http://icurrencyfair.herokuapp.com/messages?gte=1472307967043</a></code></li>
    <li><code><a href="http://icurrencyfair.herokuapp.com/user/58522695/messages">http://icurrencyfair.herokuapp.com/user/58522695/messages</a></code></li>
</ul>

 <br />
 <hr />
 <br />
 
 
 <h2>Testing</h2>
 
<code> for authentication - username : client and password alfanum123</code> 
 <p>Run the file <code>test-endpoint.sh</code> that  calls the endpoint and prints in console the response. </p>
 <ul>
     <li><code>./test-endpoint.sh client alfanum123  http://icurrencyfair.herokuapp.com/messages</code></li>
     <li><code> curl -G http://icurrencyfair.herokuapp.com/messages?gte=1472307967043 | jq </code></li>
     <li><code>.curl -G http://icurrencyfair.herokuapp.com/users/2333212/messages  | jq </code></li>
 </ul>
 
 * <code><a href="https://stedolan.github.io/jq/">jq</a></code>  - command-line JSON processor 

 <br />
 <hr />
 <br />
  <br />
   <br />