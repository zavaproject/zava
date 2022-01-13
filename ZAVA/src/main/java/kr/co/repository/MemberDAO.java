package kr.co.repository;

import java.util.List;

import kr.co.domain.MemberVO;
import kr.co.domain.PageTO;

public interface MemberDAO {
	
	public List<MemberVO> list();

	public List<MemberVO> list(PageTO<MemberVO> pt);

	public MemberVO read(String mid);

	public MemberVO login(MemberVO vo);

	public void insert(MemberVO vo);

	public void update(MemberVO vo);

	public MemberVO updateUI(String mid);

	public void delete(MemberVO vo);

	public void insertoperator(MemberVO vo);

	public MemberVO idcheck(String mid);

	public int getAmount();

}
