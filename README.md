# WebScraping
Scarping [HackerNews](https://news.ycombinator.com/) using HtmlUnit

# Technology Stack
1. **HtmlUnit** library is used to as the Webclient and load the Base Url
2. **Jackson** library is used to map Java Object `HackerNewsItem` to Json
 

# Idea
The list of htmlElements/WebElemnts is scraped and from there using `relative xpath` looped inside the list of html elements and each web element is scraped using Xpath Expression. 

# Maven Project Dependencies
```
 <dependencies>
        <dependency>
            <groupId>net.sourceforge.htmlunit</groupId>
            <artifactId>htmlunit</artifactId>
            <version>2.28</version>
        </dependency>

        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.7.0</version>
        </dependency>
    </dependencies>
```
# Usage
Execute the Class `WebScrapper`

# Input
![Input](https://github.com/priya006/WebScraping/blob/master/Input.png)

# Output
![Output](https://github.com/priya006/WebScraping/blob/master/Output.png)

# Important
 Brush up your Xpath Skills :) 

# Reference:
[Xpath](https://devhints.io/xpath)








