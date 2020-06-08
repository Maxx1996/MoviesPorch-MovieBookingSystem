using System;
using System.Collections.Generic;
using System.Linq;
using StackOverflowProject.DomainModels;

namespace StackOverflowProject.Repositories
{

    public interface IQuestionsRepository
    {
        void InsertQuestion(Question q);
        void UpdateQuestionDetails(Question q);
        void UpdateQuestionVotesCount(int qid, int value);
        void UpdateQuestionAnswersCount(int qid, int value);
        void UpdateQuestionViewsCount(int qid, int value);
        void DeleteQuestion(int qid);
        List<Question> GetQuestions();
        List<Question> GetQuestionByQuestionID(int QuestionID);
    }

    public class QuestionsRepository : IQuestionsRepository
    {
        StackOverflowDatabaseDbContext db;
        public QuestionsRepository()
        {
            db = new StackOverflowDatabaseDbContext();
        }
        public void DeleteQuestion(int qid)
        {
            Question qn = db.Questions.Where(temp => temp.QuestionID == qid).FirstOrDefault();
            if (qn != null)
            {
                db.Questions.Remove(qn);
                db.SaveChanges();
            }
        }

        public List<Question> GetQuestionByQuestionID(int QuestionID)
        {
            List<Question> qt = db.Questions.Where(temp => temp.QuestionID == QuestionID).ToList();
            return qt;
        }

        public List<Question> GetQuestions()
        {
            List<Question> qn = db.Questions.OrderByDescending(temp => temp.QuestionDateAndTime).ToList();
            return qn;
        }

        public void InsertQuestion(Question q)
        {
            db.Questions.Add(q);
            db.SaveChanges();
        }

        public void UpdateQuestionAnswersCount(int qid, int value)
        {
            Question qt = db.Questions.Where(temp => temp.QuestionID == qid).FirstOrDefault();
            if (qt != null)
            {
                qt.AnswersCount += value;
                db.SaveChanges();
            }
        }

        public void UpdateQuestionDetails(Question q)
        {
            Question qn = db.Questions.Where(temp => temp.QuestionID == q.QuestionID).FirstOrDefault();
            if(qn != null)
            {
                qn.QuestionName = q.QuestionName;
                qn.QuestionDateAndTime = q.QuestionDateAndTime;
                qn.CategoryID = q.CategoryID;
                db.SaveChanges();
            }
        }

        public void UpdateQuestionViewsCount(int qid, int value)
        {
            Question qt = db.Questions.Where(temp => temp.QuestionID == qid).FirstOrDefault();
            if (qt != null)
            {
                qt.ViewsCount += value;
                db.SaveChanges();
            }
        }

        public void UpdateQuestionVotesCount(int qid, int value)
        {
            Question qt = db.Questions.Where(temp => temp.QuestionID == qid).FirstOrDefault();
            if (qt != null)
            {
                qt.VotesCount += value;
                db.SaveChanges();
            }
        }
    }
}
