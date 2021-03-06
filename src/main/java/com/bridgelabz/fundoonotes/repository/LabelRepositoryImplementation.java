package com.bridgelabz.fundoonotes.repository;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoonotes.entity.LabelInformation;
import com.bridgelabz.fundoonotes.entity.NoteInformation;

/**
 * 
 * @author chaithra B N
 *
 */

@Repository
public class LabelRepositoryImplementation implements LabelRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public LabelInformation save(LabelInformation labelInformation) {

		Session session = entityManager.unwrap(Session.class);
		session.save(labelInformation);
		return labelInformation;
	}

	@Override
	public NoteInformation saveNote(NoteInformation noteInformation) {

		Session session = entityManager.unwrap(Session.class);
		session.save(noteInformation);
		return noteInformation;
	}

	@Override
	public LabelInformation fetchLabel(Long userid, String labelname) {

		Session session = entityManager.unwrap(Session.class);
		Query q = session.createQuery("from LabelInformation where user_id=:id and name=:name");
		q.setParameter("id", userid);
		q.setParameter("name", labelname);
		return (LabelInformation) q.uniqueResult();

	}

	@Override
	public LabelInformation fetchLabelById(Long id) {

		Session session = entityManager.unwrap(Session.class);
		Query q = session.createQuery("from LabelInformation where label_id=:id");
		q.setParameter("id", id);

		return (LabelInformation) q.uniqueResult();

	}

	@Override
	public int deleteLabel(Long i) {
		String hql = "DELETE FROM LabelInformation " + "WHERE label_id = :id";
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery(hql);
		query.setParameter("id", i);
		int result = query.executeUpdate();
		return result;
	}

}
