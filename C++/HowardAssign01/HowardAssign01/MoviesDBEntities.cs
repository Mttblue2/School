using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

public class MoviesDBEntities : DbContext
{
    // You can add custom code to this file. Changes will not be overwritten.
    // 
    // If you want Entity Framework to drop and regenerate your database
    // automatically whenever you change your model schema, please use data migrations.
    // For more information refer to the documentation:
    // http://msdn.microsoft.com/en-us/data/jj591621.aspx

    public MoviesDBEntities() : base("name=MoviesDBEntities")
    {
    }

    public System.Data.Entity.DbSet<HowardAssign01.Models.Actor> Actors { get; set; }

    public System.Data.Entity.DbSet<HowardAssign01.Models.Genre> Genres { get; set; }

    public System.Data.Entity.DbSet<HowardAssign01.Models.Movie> Movies { get; set; }

    public System.Data.Entity.DbSet<HowardAssign01.Models.Rating> Ratings { get; set; }

    public System.Data.Entity.DbSet<HowardAssign01.Models.MovieActor> MovieActors { get; set; }
}
