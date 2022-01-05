# Escape From Darkness

## Guideline

1. Install MySQL database on your machine
2. Go to the file `application.properties` on the path `src/main/resources/application.properties`
3. Change the `spring.datasource.username` to be your username, `spring.datasource.password` to your password and change
   the `spring.datasource.url` to the url where your MySQL is on
4. The currently default database name is `escape-from-darkness`. Make sure to create a database with the same name to
   the one on the `spring.datasource.url` property
5. Run the application, the default port it will start up on is port 8080