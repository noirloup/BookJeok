package book.model.service;

import static common.JDBCTemp.*;
import java.sql.Connection;
import java.util.ArrayList;

import book.model.dao.BookDao;
import book.model.vo.Book;

public class BookService {
	private BookDao bdao = new BookDao();
	
	public ArrayList<Book> selectBookList() {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectBookList(conn);
		close(conn);
		return list;
	}
	
	public Book selectOneDetail(int bookId) {
		Connection conn = getConnection();
		Book book = bdao.selectOneDetail(conn, bookId);
		close(conn);
		return book;
	}
	
	
	public ArrayList<Book> selectBestTop10(){
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectBestTop10(conn);
		close(conn);
		return list;
	}
	
	public ArrayList<Book> selectBestBookList() {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectBestBookList(conn);
		close(conn);
		return list;
		
	}
	
	public ArrayList<Book> selectNewTop10(){
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectNewTop10(conn);
		close(conn);
		return list;
	}
	
	public ArrayList<Book> selectNewBookList() {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectNewBookList(conn);
		close(conn);
		return list;
		
	}
	public ArrayList<Book> selectBookStoreList() {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectBookStoreList(conn);
		close(conn);
		return list;
	}

	
	public int selectBookDetail(int bookId){
		int result = 0;
		return result;
		
	}
	
	public int insertAdminBookInfo(Book book) {
		int result = 0;
		return result;
		
	}
	
	public int deleteAdminBookInfo(int bookId) {
		int result = 0;
		return result;
		
	}
	
	public int updateAdminBookInfo(Book book) {
		int result = 0;
		return result;
	}

	public ArrayList<Book> selectBestETop10() {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectBestETop10(conn);
		close(conn);
		return list;
	}

	public ArrayList<Book> selectNewETop10() {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectNewETop10(conn);
		close(conn);
		return list;
	}

	public ArrayList<Book> selectBestATop10() {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectBestATop10(conn);
		close(conn);
		return list;
	}

	public ArrayList<Book> selectNewATop10() {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectNewATop10(conn);
		close(conn);
		return list;
	}


	public Book selectOneBookNmDetail(String bookNm) {
		Connection conn = getConnection();
		Book book = bdao.selectOneBookNmDetail(conn, bookNm);
		close(conn);
		return book;
	}
	
	public Book selectOneBookAuthorDetail(String bookAuthor) {
		Connection conn = getConnection();
		Book book = bdao.selectOneBookAuthorDetail(conn, bookAuthor);
		close(conn);
		return book;
	}

	public Book selectEOneDetail(int bookId) {
		Connection conn = getConnection();
		Book book = bdao.selectEOneDetail(conn, bookId);
		close(conn);
		return book;
	}

	public Book selectEOneNmDetail(String bookNm) {
		Connection conn = getConnection();
		Book book = bdao.selectEOneBookNmDetail(conn, bookNm);
		close(conn);
		return book;
	}

//	public Book selectEOneAuthorDetail(String bookAuthor) {
//		Connection conn = getConnection();
//		Book book = bdao.selectEOneBookAuthorDetail(conn, bookAuthor);
//		close(conn);
//		return book;
//	}

	public Book selectAOneDetail(int bookId) {
		Connection conn = getConnection();
		Book book = bdao.selectAOneDetail(conn, bookId);
		close(conn);
		return book;
	}

	public Book selectAOneNmDetail(String bookNm) {
		Connection conn = getConnection();
		Book book = bdao.selectAOneBookNmDetail(conn, bookNm);
		close(conn);
		return book;
	}

	public Book selectAOneAuthorDetail(String bookAuthor) {
		Connection conn = getConnection();
		Book book = bdao.selectAOneBookAuthorDetail(conn, bookAuthor);
		close(conn);
		return book;
	}

	
	public ArrayList<Book> selectCategory(int location, int category) {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectCategory(conn, location, category);
		close(conn);
		return list;
	}

	public int getBookListCount(int location, int category) {
		Connection conn = getConnection();
		int listCount = bdao.getBookListCount(conn, location, category);
		close(conn);
		return listCount;
	}

	public int insertAdminBook(Book book) {
		Connection conn = getConnection();
		int result = bdao.insertAdminBook(conn, book);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int getBookTotalListCount() {
		Connection conn = getConnection();
		int listCount = bdao.getBookTotalListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Book> selectProductSearchBookName(int location, int category, String keyword) {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectProductSearchBookName(conn, location, category, keyword);
		close(conn);
		return list;
	}

	public ArrayList<Book> selectProductSearchAuthor(int location, int category, String keyword) {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectProductSearchAuthor(conn, location, category, keyword);
		close(conn);
		return list;
	}

	public ArrayList<Book> selectProductAdminSearchBookName(String keyword) {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectProductAdminSearchBookName(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<Book> selectProductAdminSearchAuthor(String keyword) {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectProductAdminSearchAuthor(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<Book> selectProductAdminSearchPublisher(String keyword) {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectProductAdminSearchPublisher(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<Book> selectPBookSearchBookName(String keyword) {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectPBookSearchBookName(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<Book> selectPBookSearchAuthor(String keyword) {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectPBookSearchAuthor(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<Book> selectEBookSearchBookName(String keyword) {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectEBookSearchBookName(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<Book> selectEBookSearchAuthor(String keyword) {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectEBookSearchAuthor(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<Book> selectABookSearchBookName(String keyword) {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectABookSearchBookName(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<Book> selectABookSearchAuthor(String keyword) {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectABookSearchAuthor(conn, keyword);
		close(conn);
		return list;
	}

	
	public Book certificate(String book_nm, int isbn) {
		Connection conn = getConnection();
		Book book = bdao.certificate(conn, book_nm, isbn);
		close(conn);
		return book;
	}
	

	public ArrayList<Book> selectProductSearchBookName1(int category, String keyword) {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectProductSearchBookName1(conn, category, keyword);
		close(conn);
		return list;
	}

	public ArrayList<Book> selectProductSearchAuthor1(int category, String keyword) {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectProductSearchAuthor1(conn, category, keyword);
		close(conn);
		return list;
	}

	public ArrayList<Book> selectProductSearchBookName2(int location, String keyword) {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectProductSearchBookName2(conn, location, keyword);
		close(conn);
		return list;
	}

	public ArrayList<Book> selectProductSearchAuthor2(int location, String keyword) {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectProductSearchAuthor2(conn, location, keyword);
		close(conn);
		return list;
	}

	public ArrayList<Book> selectProductSearchBookName3(int location, int category, String keyword) {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectProductSearchBookName3(conn, location, category, keyword);
		close(conn);
		return list;
	}

	public ArrayList<Book> selectProductSearchAuthor3(int location, int category, String keyword) {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectProductSearchAuthor3(conn, location, category, keyword);
		close(conn);
		return list;
	}

	public ArrayList<Book> selectProductSearchBookName4(String keyword) {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectProductSearchBookName4(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<Book> selectProductSearchAuthor4(String keyword) {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectProductSearchAuthor4(conn, keyword);
		close(conn);
		return list;
	}
	public ArrayList<Book> selectBestTop4() {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectBestTop4(conn);
		close(conn);
		return list;
	}

	public int updateAdminBook(Book book) {
		Connection conn = getConnection();
		int result = bdao.updateAdminBook(conn, book);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteBook(int bookId) {
		Connection conn = getConnection();
		int result = bdao.deleteBook(conn, bookId);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Book selectAdminOneDetail(int bookId) {
		Connection conn = getConnection();
		Book book = bdao.selectAdminOneDetail(conn, bookId);
		close(conn);
		return book;
	}

	public Book selectAllOneDetail(int bookId) {
		Connection conn = getConnection();
		Book book = bdao.selectAllOneDetail(conn, bookId);
		close(conn);
		return book;
	}


	
	

}