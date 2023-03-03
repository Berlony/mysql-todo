import java.sql.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Connection con = Database.getInstance();

        Statement stmt = con.createStatement();
        ResultSet rs;
        PreparedStatement st;

        String qry = "";
        int id, choice;
        String itemName, status;

        Scanner in = new Scanner(System.in);
        Scanner str = new Scanner(System.in);

        while (true) {
            System.out.println("Todo List");
            System.out.println("Please select what you want to do");
            System.out.println("1. Insert");
            System.out.println("2. Select");
            System.out.println("3. Delete");
            System.out.println("4. Update");
            System.out.println("5. Exit");
            System.out.print("Enter a choice: ");
            choice = in.nextInt();
            System.out.println("-----------------------------------------");

            switch (choice) {
                case 1:
                    System.out.println("1. Insert New Data");

                    System.out.println("Enter what you want to do: ");
                    itemName = str.nextLine();

                    System.out.println("Status: ");
                    status = str.nextLine();

                    qry = "insert into `todo` (itemName,status) values(?,?)";
                    st = con.prepareStatement(qry);
                    st.setString(1, itemName);
                    st.setString(2, status);

                    st.executeUpdate();
                    System.out.println("Data Insert Success");

                    break;
                case 2:
                    System.out.println("2. Print all Records");
                    qry = "SELECT * from todo";
                    rs = stmt.executeQuery(qry);
                    while (rs.next()) {
                        id = rs.getInt("id");
                        itemName = rs.getString("itemName");
                        status = rs.getString("status");

                        System.out.println(id + " ");
                        System.out.println(itemName + " ");
                        System.out.println(status + " ");

                    }
                    break;

                case 3:
                    System.out.println("3. Deleting a Data");
                    System.out.println("Enter ID : ");
                    id = in.nextInt();

                    qry = "delete from todo where id=?";
                    st = con.prepareStatement(qry);
                    st.setInt(1, id);

                    st.executeUpdate();
                    System.out.println("Data Deleted Success");

                    break;
                case 4:
                    System.out.println("4. Updating a Data");

                    System.out.println("Enter ID: ");
                    id = in.nextInt();
                    System.out.println("What do you want to do: ");
                    itemName = str.nextLine();
                    System.out.println("Enter Status: ");
                    status = str.nextLine();

                    qry = "update todo set itemName=?,status=? where id=?";
                    st = con.prepareStatement(qry);

                    st.setString(1, itemName);
                    st.setString(2, status);
                    st.setInt(3, id);
                    st.executeUpdate();
                    System.out.println("Data Update Success");

                    break;
                case 5:
                    System.out.println("Thank You");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Selection");
                    break;
            }
        }
    }
}