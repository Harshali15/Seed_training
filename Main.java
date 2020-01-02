package com.seed.deloitte;

import java.sql.*;
import java.util.*;
import oracle.jdbc.driver.OracleDriver;

public class Main {

	public static void main(String args[]) {
		Driver d;
		Connection conn = null;

		try {
			// -------------------load and register the driver----------------------

			System.out.println("Loading the driver");
			d = new OracleDriver();
			DriverManager.registerDriver(d);

			System.out.println("Registering driver complete");
			// establish connection with the database

			String userName = "hr";
			String password = "hr";
			String url = "jdbc:oracle:thin:@192.168.1.59:1521:xe";

			System.out.println("Creating a connection");
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("Connection created");

			conn.setAutoCommit(false);

			// ------------------switch case-----------------------------

			int choice;

			System.out.print("Enter a choice\n1.Insert a new entry\n2.Read\n3.Delete\n4.Update\n");
			Scanner in = new Scanner(System.in);

			choice = in.nextInt();

			do {

				switch (choice) {
				case 1: // INSERT

					String query = "insert into books values(?,?,?,?)";

					PreparedStatement pstmt = conn.prepareStatement(query);

					String title, author;
					int book_id, isbn;

					System.out.println("Enter values id, title, author, isbn");

					book_id = in.nextInt();
					title = in.next();
					author = in.next();
					isbn = in.nextInt();

					pstmt.setInt(1, book_id);
					pstmt.setString(2, title);
					pstmt.setString(3, author);
					pstmt.setInt(4, isbn);

					int res = pstmt.executeUpdate();

					System.out.println(res + "row(s) inserted");

					conn.commit();

					break;
				case 2: // DISPLAY
					 
					 Statement stmt= conn.createStatement(); 
					 
					 query="Select* from books order by book_id ";
					 
					 ResultSet rs=stmt.executeQuery(query);
					 
					 conn.commit();
					 while(rs.next())
					 { 
						 System.out.println("\nBook Id : "+ rs.getInt("book_id") +
					 "\nTitle : " + rs.getString("title")+ "\n Author" + rs.getString("author")
					 +"\n ISBN : "+ rs.getInt("isbn")); 
						 
						 
					 }
					 
					break;
				case 3://DELETE
					
					query = "delete from books where book_id=?";
					PreparedStatement pstmt1 = conn.prepareStatement(query);


					conn.prepareStatement(query);

					int id;

					System.out.println("Enter book id to delete");

					id = in.nextInt();
					
					pstmt1.setInt(1, id);
					
					res = pstmt1.executeUpdate();
					
					System.out.println(res + "row(s) deleted");

					conn.commit();

					break;
					
				case 4: 
					query = "update books set title = ? where book_id=?";
					
					PreparedStatement pstmt2 = conn.prepareStatement(query);


					conn.prepareStatement(query);

					String titl;

					System.out.println("Enter book id to update details.");
					
					id=in.nextInt();
					
					System.out.println("Enter new name for the book");

                    titl= in.next();
					
					pstmt2.setString(1,titl );
					
					pstmt2.setInt(2,id);
					
					res = pstmt2.executeUpdate();
					
					System.out.println(res + "row(s) updated");

					conn.commit();
					break;
					
				}
				
				System.out.print("Enter a choice\n1.Insert a new entry\n2.Read\n3.Delete\n4.Update\n");

				choice = in.nextInt();

			} while (choice <4 );

		} catch (SQLException e) {
			try {
				System.out.println("Error occured..rolling back transaction");
				conn.rollback();
			} catch (SQLException x) {
				x.printStackTrace();
			}

			// System.err.println("Error in registering the server");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Closing the connection");

			} catch (SQLException e) {

				System.err.println("Error while closing connection");
				e.printStackTrace();
			}

			// System.out.println("Closing the database connection");
		}
	}
}

/*
 *************************OUTPUT*****************************
 *Loading the driver
Registering driver complete
Creating a connection
Connection created
Enter a choice
1.Insert a new entry
2.Read
3.Delete
4.Update
4
Enter book id to update details.
1
Enter new name for the book
mindcontrol
1row(s) updated
Enter a choice
1.Insert a new entry
2.Read
3.Delete
4.Update
2

Book Id : 1
Title : mindcontrol
 AuthorJ K Rowling
 ISBN : 123

Book Id : 2
Title : Looking for Alaska
 AuthorJohn Green
 ISBN : 222

Book Id : 3
Title : The Secret
 AuthorRhonda Byrne
 ISBN : 333

Book Id : 5
Title : Alaska
 AuthorJohn G
 ISBN : 567

Book Id : 7
Title : Alaska
 AuthorJohnGreen
 ISBN : 789
Enter a choice
1.Insert a new entry
2.Read
3.Delete
4.Update
1
Enter values id, title, author, isbn
4 Meluha Shiva 27
1row(s) inserted
Enter a choice
1.Insert a new entry
2.Read
3.Delete
4.Update
2

Book Id : 1
Title : mindcontrol
 AuthorJ K Rowling
 ISBN : 123

Book Id : 2
Title : Looking for Alaska
 AuthorJohn Green
 ISBN : 222

Book Id : 3
Title : The Secret
 AuthorRhonda Byrne
 ISBN : 333

Book Id : 4
Title : Meluha
 AuthorShiva
 ISBN : 27

Book Id : 5
Title : Alaska
 AuthorJohn G
 ISBN : 567

Book Id : 7
Title : Alaska
 AuthorJohnGreen
 ISBN : 789
Enter a choice
1.Insert a new entry
2.Read
3.Delete
4.Update
3
Enter book id to delete
4
1row(s) deleted
Enter a choice
1.Insert a new entry
2.Read
3.Delete
4.Update
2

Book Id : 1
Title : mindcontrol
 AuthorJ K Rowling
 ISBN : 123

Book Id : 2
Title : Looking for Alaska
 AuthorJohn Green
 ISBN : 222

Book Id : 3
Title : The Secret
 AuthorRhonda Byrne
 ISBN : 333

Book Id : 5
Title : Alaska
 AuthorJohn G
 ISBN : 567

Book Id : 7
Title : Alaska
 AuthorJohnGreen
 ISBN : 789
Enter a choice
1.Insert a new entry
2.Read
3.Delete
4.Update
5
Closing the connection
 * */
