using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using StackOverflowProject.DomainModels;
using StackOverflowProject.ViewModels;
using StackOverflowProject.Repositories;
using AutoMapper;
using AutoMapper.Configuration;

namespace StackOverflowProject.ServiceModels
{
    public interface ICategoriesServive
    {
        void InsertCategory(CategoryViewModel cvm);
        void UpdateCategory(CategoryViewModel cvm);
        void DeleteCategory(int cid);
        List<CategoryViewModel> GetCategories();
        CategoryViewModel GetCategoryByCategoryID(int CategoryID);
    }
    public class CategoriesService : ICategoriesServive
    {
        IcategoriesRepository cr;
        public CategoriesService()
        {
            cr = new CategoriesRepository();
        }
        public void DeleteCategory(int cid)
        {
            cr.DeleteCategories(cid);
        }

        public List<CategoryViewModel> GetCategories()
        {
            List<Category> c = cr.GetCategories();
            var config = new MapperConfiguration(cfg => { cfg.CreateMap<Category, CategoryViewModel>(); cfg.IgnoreUnmapped(); });
            IMapper mapper = config.CreateMapper();
            List<CategoryViewModel> cvm = mapper.Map<List<Category>, List<CategoryViewModel>>(c);
            return cvm;

        }

        public CategoryViewModel GetCategoryByCategoryID(int CategoryID)
        {
            Category c = cr.GetCategoryByCategoryID(CategoryID).FirstOrDefault();
            CategoryViewModel cvm = null;
            if (c != null)
            {
                var config = new MapperConfiguration(cfg => { cfg.CreateMap<Category, CategoryViewModel>(); cfg.IgnoreUnmapped(); });
                IMapper mapper = config.CreateMapper();
                cvm = mapper.Map<Category, CategoryViewModel>(c);
                return cvm;
            }
            return cvm;
        }

        public void InsertCategory(CategoryViewModel cvm)
        {
            var config = new MapperConfiguration(cfg => { cfg.CreateMap<CategoryViewModel, Category>(); cfg.IgnoreUnmapped(); });
            IMapper mapper = config.CreateMapper();
            Category c = mapper.Map<CategoryViewModel, Category>(cvm);
            cr.InsertCategories(c);
        }

        public void UpdateCategory(CategoryViewModel cvm)
        {
            var config = new MapperConfiguration(cfg => { cfg.CreateMap<CategoryViewModel, Category>(); cfg.IgnoreUnmapped(); });
            IMapper mapper = config.CreateMapper();
            Category c = mapper.Map<CategoryViewModel, Category>(cvm);
            cr.UpdateCategories(c);
        }
    }
}
