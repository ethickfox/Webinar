# How to use?

All logic encapsulated in:

```java
RandomUserRequester.requestUser("some parameters");
```

This method returns json string of users in format:

 ```json
{
  "results": [
    {
      //      user data;
    },
    {
      //      user data;
    }
  ]
}
```
There are special parameters saved in request-settings.json, that could be passed to requestUser, use List of Parameter objects, where parameter.key is name of setting and parameter.value - value.
