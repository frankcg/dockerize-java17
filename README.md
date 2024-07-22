SERVICES
DOCUMENTS
Reto Tecnico - BideaFactory.md
PREVIEW AS 
EXPORT AS 
SAVE TO 
IMPORT FROM 
DOCUMENT NAME
Reto Tecnico - BideaFactory.md
MARKDOWNPREVIEWToggle Mode
  
<h1 class="code-line" data-line-start=0 data-line-end=1 ><a id="Reto_Tecnico__BideaFactory_0"></a>Reto Tecnico - BideaFactory</h1>
<h2 class="code-line" data-line-start=1 data-line-end=2 ><a id="Sebastian_Cabrera_1"></a>Sebastian Cabrera</h2>
<h2 class="code-line" data-line-start=3 data-line-end=4 ><a id="Paso_1_3"></a>Paso 1</h2>
<p class="has-line-data" data-line-start="5" data-line-end="6">Ejecutar los siguientes comandos.</p>
<pre><code class="has-line-data" data-line-start="8" data-line-end="13" class="language-sh">
docker-compose up --build
<span class="hljs-comment"># Detener contenedores</span>
docker-compose down
</code></pre>
<p class="has-line-data" data-line-start="13" data-line-end="14">CURL POSTMAN</p>
<pre><code class="has-line-data" data-line-start="16" data-line-end="29" class="language-sh">curl --location <span class="hljs-string">'http://localhost:8080/v1/bideafactory/book'</span> \
--header <span class="hljs-string">'Content-Type: application/json'</span> \
--data <span class="hljs-string">'{
    "id": "UID-004",
    "name": "Sebastian",
    "lastname": "Cabrera",
    "age": 29,
    "phoneNumber": "51997446829",
    "startDate": "2025-01-01",
    "endDate": "2025-01-02",
    "houseId": "98765431-HS"
}'</span>
</code></pre>
<pre><code class="has-line-data" data-line-start="31" data-line-end="33" class="language-sh">curl --location <span class="hljs-string">'http://localhost:8080/v1/bideafactory/book'</span>
</code></pre>
