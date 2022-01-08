# Escape From Darkness

## Guideline

1. Install MySQL database on your machine
2. Go to the file `application.properties` on the path `src/main/resources/application.properties`
3. Change the `spring.datasource.username` to be your username, `spring.datasource.password` to your password and change
   the `spring.datasource.url` to the url where your MySQL is hosted on
4. The currently default database name is `escape-from-darkness`. Make sure to create a database with the same name to
   the one on the `spring.datasource.url` property
5. Run the application, the default port it will start up on is port 8080

Note: The first time the application starts, the application will generate the schema for the database with no initial
data. You can seed the database with default `Level`, `Enemy`, `Weapon`, `Armor`, `HP`, `MP` by changing the property 
`spring.datasource.initialization-mode` from `never` to be `always`. Changing this and restarting, the database will be
initialized with default data in the `src/main/resources/data.sql` file. **Remember to disable this property after seeding if you
wish to restart the application due to the seeding will be ran again resulting in error in primary key violation.**

