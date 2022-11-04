package co.edu.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.book.BookVO;

public class BookDAO extends DAO {

	// 도서목록
	public List<BookVO> bookList() {
		getConnect();
		List<BookVO> list = new ArrayList<>();
		String sql = "select * from tbl_book";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BookVO vo = new BookVO();
				vo.setBook_code(rs.getString("book_code"));
				vo.setBook_name(rs.getString("book_name"));
				vo.setAuthor("author");
				vo.setPress(rs.getString("press"));
				vo.setPrice(rs.getInt("price"));

				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		// 도서목록을 반환하도록 구성.
		return list;
	}

	// 도서입력
	public void insertBook(BookVO vo) {
		getConnect();
		String sql = "insert into tbl_book (book_code, book_name, author, press, price)" //
				+ "values(?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBook_code());
			psmt.setString(2, vo.getBook_name());
			psmt.setString(3, vo.getAuthor());
			psmt.setString(4, vo.getPress());
			psmt.setInt(5, vo.getPrice());

			psmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	//도서삭제
	public boolean deleteBook(String book_code) {
		getConnect();
		String sql = "delete from tbl_book where book_code=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book_code);
			int r = psmt.executeUpdate();
			if (r > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;

	}

}
	