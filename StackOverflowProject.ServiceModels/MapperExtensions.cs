using System;
using System.Collections.Generic;
using System.Linq;
using AutoMapper;

namespace StackOverflowProject.ServiceModels
{
    public static class MapperExtensions
    {
        private static void ignoreUnmappedProperties(TypeMap map, IMappingExpression expr)
        {
            foreach(string propName in map.GetUnmappedPropertyNames())
            {
                if (map.SourceType.GetProperty(propName) != null)
                {
                    expr.ForMember(propName, opt => opt.Ignore());
                }
                if(map.DestinationType.GetProperty(propName) != null)
                {
                    expr.ForMember(propName, opt => opt.Ignore());
                }
            }
        }
        public static void IgnoreUnmapped(this IProfileExpression profile)
        {
            profile.ForAllMaps(ignoreUnmappedProperties);
        }
    }

    
}
