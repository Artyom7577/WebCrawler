### WebCrawler


1. **Purpose:**
    - The `WebCrawler` class is designed to perform web crawling on HTML pages up to a specified depth.

2. **Dependencies:**
    - It uses the `Jsoup` library for HTML parsing and HTTP connection.

3. **Thread Execution:**
    - The class implements the `Runnable` interface and runs in a separate thread to avoid blocking the main application.

4. **Constructor:**
    - Takes a starting URL and a unique identifier (`ID`) for the crawler instance.

5. **Method: `crawl`**
    - Recursively crawls links up to a specified depth.
    - Uses a `HashSet` (`visitedLinks`) to track visited URLs and avoid duplicate crawling.

6. **Method: `request`**
    - Performs an HTTP request to the specified URL using `Jsoup`.
    - Checks if the response status code is 200 before processing the HTML.

7. **Output:**
    - Outputs the received webpage title to the console, along with the unique identifier (`ID`) and the URL.
    - Visited links are stored in the `visitedLinks` set.

8. **Getter Method: `getThread`**
    - Provides access to the thread running the `WebCrawler` instance.

### WebCrawlerForDb

1. **Purpose:**
    - The `WebCrawlerForDb` class is designed to collect user data from a specified API endpoint.

2. **Dependencies:**
    - It uses the `Apache HttpClient` library for making HTTP requests.

3. **Thread Execution:**
    - Like the `WebCrawler` class, it implements the `Runnable` interface and runs in a separate thread.

4. **Constructor:**
    - Takes an API endpoint URL and a unique identifier (`ID`) for the crawler instance.

5. **Method: `collectUserData`**
    - Performs an HTTP GET request to the specified API endpoint.
    - Checks the response status code and processes the received JSON data.

6. **Output:**
    - Outputs the received HTTP status code, the unique identifier (`ID`), and the API endpoint URL to the console.
    - Displays the collected user data (JSON) to the console.
    - Visited API endpoints are stored in the `visitedUsers` set.

7. **Getter Method: `getThread`**
    - Provides access to the thread running the `WebCrawlerForDb` instance.

### How to Run

1. **Adjust `MAX_DEPTH`:**
    - Modify the `MAX_DEPTH` variable in both classes based on the desired depth for crawling.

2. **Create Instances:**
    - Instantiate `WebCrawler` and `WebCrawlerForDb` objects in your application, providing appropriate parameters.

3. **Run Threads:**
    - The crawlers run in separate threads and automatically start upon instantiation.

4. **Console Output:**
    - The console output will show information about visited web pages or API endpoints along with relevant data.

### Notes and Considerations

- **SSL Handling:**
    - The code assumes a development environment and may not handle SSL certificate validation. In production, proper SSL handling should be implemented.

- **Thread Safety:**
    - The code does not include explicit thread safety mechanisms. Depending on the context, you might need to consider adding synchronization for shared data structures.

- **API Rate Limiting:**
    - Be aware of API rate limits to avoid potential issues with excessive requests.

- **Error Handling:**
    - The code includes basic error handling but can be extended based on specific use cases.

