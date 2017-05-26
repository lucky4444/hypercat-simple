# hypercat-simple

hypercat-simple is a basic server implementation of the hypercat standard version 3.00rc1-­2016­-02-23.



## Requirements

* JDK 8
* MongoDB
* Maven2

## Quick start

Clone the latest version from https://github.com/lucky4444/hypercat-simple and place it in a location of your choice.

1. Open a terminal in the root directory of the application.
2. Execute `mvn spring-boot:run` to let maven download all necessary dependencies and start the application.
3. Open your browser/postman and navigate to [localhost:8080/cat](http://localhost:8080/cat)


### Usage

#### GET localhost:8080/cat

Retrieves all resources of the catalog. A response looks like this:

```json
{
    "catalogue-metadata": [
        {
            "rel": "urn:X-hypercat:rels:hasDescription:en",
            "val": "A Simple Hypercat Catalogue"
        },
        {
            "rel": "urn:X-hypercat:rels:isContentType",
            "val": "application/vnd.hypercat.catalogue+json"
        },
        {
            "rel": "urn:X-hypercat:rels:supportsSearch",
            "val": "urn:X-hypercat:search:simple"
        }
    ],
    "items": [
        {
            "href": "http://www.foo.bar/foo/bar",
            "item-metadata": [
                {
                    "rel": "key1",
                    "val": "value1"
                },
                {
                    "rel": "urn:X-hypercat:rels:hasDescription:en",
                    "val": "Sample resource"
                }
            ]
        },
        {
            "href": "http://www.bar.foo/bar/foo",
            "item-metadata": [
                {
                    "rel": "key2",
                    "val": "value2"
                },
                {
                    "rel": "urn:X-hypercat:rels:hasDescription:en",
                    "val": "Sample resource 2"
                }
            ]
        }
    ]
}
```

#### POST localhost:8080/cat?href=bla.txt

Creates a new resource.
The request body must contain a json structure like this:

```json
{
	"href": "bla.txt",
	"item-metadata": [
		{
			"rel": "key1",
			"val": "value1"
		},
		{
			"rel": "urn:X-hypercat:rels:hasDescription:en",
			"val": "test resource"
		}

	]
}
```

As specified in hypercat standard v3.00rc1-­2016­-02-23 it is mandatory to include a href and item-metadata property. The item-metadata furthermore has to contain at least the one relationship
`urn:X­hypercat:rels:hasDescription:en` but can otherwise have as many relationships as wanted.

#### PUT localhost:8080/cat?href=bla.txt

Updates the resource specified in query parameter `href`. The same can be achieved by the POST operation if executed on an existing resource.

#### DELETE localhost:8080/cat?href=bla.txt

Deletes the resource specified in query parameter `href`.