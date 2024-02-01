package Query;

public class SqlQuery {
    public static  String create = "CREATE TABLE employee (\n" +
            "    id INT PRIMARY KEY,\n" +
            "    name VARCHAR(255),\n" +
            "    email VARCHAR(255),\n" +
            "    salary INT\n" +
            ");";
   public static String insert = "INSERT INTO employee (id, name, email, salary) Values (?, ?, ?, ?)";
    public static String update = "UPDATE employee SET name = ? WHERE id = ?";
    public static String delete = "DELETE FROM employee WHERE id = ?";
    public static String select = "select * FROM employee";
}
