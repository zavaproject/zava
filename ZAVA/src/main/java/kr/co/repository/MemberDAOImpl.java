package kr.co.repository;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.MemberVO;
import kr.co.domain.PageTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlSession;

	private String NS = "kr.co.member";
	
	@Override
	public List<MemberVO> list() {
		return sqlSession.selectList(NS+".list");
	}

	@Override
	public List<MemberVO> list(PageTO<MemberVO> pt) {
		
		RowBounds rbs = new RowBounds(pt.getStartNum()-1, pt.getPerPage());
		
		return sqlSession.selectList(NS+".list", null, rbs);
	}

	@Override
	public MemberVO read(String mid) {
		return sqlSession.selectOne(NS + ".read", mid);
	}

	@Override
	public MemberVO login(MemberVO vo) {
		return sqlSession.selectOne(NS+".login", vo);
	}

	@Override
	public void insert(MemberVO vo) {
		sqlSession.insert(NS + ".insertmember", vo);
	}

	@Override
	public void update(MemberVO vo) {
		sqlSession.update(NS+".update", vo);
	}

	@Override
	public MemberVO updateUI(String mid) {
		return sqlSession.selectOne(NS + ".updateUI", mid);
	}

	@Override
	public void delete(MemberVO vo) {
		sqlSession.delete(NS+".delete", vo);
	}

	@Override
	public void insertoperator(MemberVO vo) {
		sqlSession.insert(NS + ".insertoperator", vo);
		
	}

	@Override
	public MemberVO idcheck(String mid) {
		return sqlSession.selectOne(NS+".idcheck", mid);
	}

	@Override
	public int getAmount() {
		return sqlSession.selectOne(NS+".getAmount");
	}

}
