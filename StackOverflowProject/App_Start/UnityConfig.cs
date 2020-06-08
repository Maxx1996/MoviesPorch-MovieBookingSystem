using System.Web.Http;
using Unity;
using Unity.WebApi;
using Unity.Mvc5;
using StackOverflowProject.ViewModels;
using StackOverflowProject.ServiceModels;
using System.Web.Mvc;

namespace StackOverflowProject
{
    public static class UnityConfig
    {
        public static void RegisterComponents()
        {
			var container = new UnityContainer();
            container.RegisterType<IQuestionsService, QuestionsService>();
            container.RegisterType<IUsersService, UsersService>();
            container.RegisterType<ICategoriesServive, CategoriesService>();
            container.RegisterType<IAnswersService, AnswersService>();
            DependencyResolver.SetResolver(new Unity.Mvc5.UnityDependencyResolver(container));
            GlobalConfiguration.Configuration.DependencyResolver = new Unity.WebApi.UnityDependencyResolver(container);
           
        }
    }
}