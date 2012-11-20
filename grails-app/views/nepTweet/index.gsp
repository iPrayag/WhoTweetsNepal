<meta name='layout' content='main'/>
<b>${message}</b>

<p>Nepal Tweets</p>
<g:each in="${tweets}" var="tweet">
     <p>${tweet}</p>
</g:each>

The json response is : <p>${tweets}</p>

<br/>
Single tweet is 
<p>${t}</p>
