# Author : Bhabani Prasad Patel
# Spring-Boot-GraphQL
  GraphQL : https://graphql.org/ 

GraphQL is a query language (that’s what the “QL” stands for) for APIs and a runtime for fulfilling those queries with your existing data. 
Basically, it is used to load data from a server to a client -- it’s a way to get data from an API into your application. 

The Origin of GraphQL :-
GraphQL was developed by Facebook in 2012 because the team needed “a data-fetching API powerful enough to describe all of Facebook, yet simple enough to be easy to learn and use by our product developers” 
when building the mobile applications. Since then, the querying language has steadily grown in popularity -- in part to Facebook open-sourcing the language in 2016.

GraphQL has proven to be incredibly effective for building modern mobile and web, giving developers a flexible, rich technology for extracting data that is more efficient and less sprawling than REST APIs. 
The real secret is that GraphQL ensures that the developer and application only loads the relevant and absolute necessary data, even if it's from multiple sources.

When Facebook needed an API data version of News Feed, they considered RESTful server resources but found differences between the data in the app and the server queries they required. G
raphQL allowed the team to approach data-fetching in a new way.

GraphQL vs REST :-
GraphQL is much different than a standard REST API where you typically have a specific endpoint or resource you’re hitting that determines an entire block of data that comes back in the returning JSON response,
 which then needs to be parsed and scattered.

GraphQL is instead established around schema, queries, and resolvers and rather aims to improve upon the REST philosophy by allowing you to ask for a specific piece of data -- not just the entire block. 
No need for parsing through a long stream of data -- you only get what you ask for. And what you ask for could be compiled from several different REST APIs.

However, let’s remember GraphQL and REST are two different things -- GraphQL is a language and a technology, while REST is an architecture pattern, which means that even as teams increasingly adopt GraphQL,
 it does not mean the end of the road for REST.

In fact, if you haven’t run in into any issues with REST, GraphQL may be of no use to you at all. In this way, GraphQL has been valuable for teams who have been limited by traditional REST APIs,
 which often arises with apps that have a complex UI/UX and typically require multiple endpoints.
 
 About this microservice :-
 1) List of stores of a company in which have once store.schema-> which has a schema of data .
 2) On Controller -> post construct will construct the schema via service with some hardcoded value have give.
 3) On end-point "/getAllStores" -> passing query string to get respective data.
 
 
