import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class FetchBookType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		ConnectionDB c=new ConnectionDB();
		con=c.get_Connection();
		HashSet<String> Booktype=new HashSet<>();
		try {
System.out.println("Enter the Book Type to get BookName the Following Book Type \n1)Digital Books\n2)Papers\n");
int booktype=scan.nextInt();			
 st=con.prepareStatement("select BookName from Books where BookType=?");  
st.setInt(1,booktype);  
rs=st.executeQuery();
			while(rs.next()) {
				Booktype.add(rs.getString(1));
			}
			List<String> booksList=new ArrayList<>(Booktype);
			Collections.sort(booksList);
			for(String s:booksList) {
				System.out.println(s);
			}

		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
