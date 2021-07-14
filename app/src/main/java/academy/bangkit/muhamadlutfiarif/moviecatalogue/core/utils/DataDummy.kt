package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.utils

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.local.entity.MovieEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.local.entity.TvShowEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.response.MovieResponse
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.response.TvShowResponse

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()
        movies.add(
            MovieEntity(
                1,
                "Alita: Battle Angel",
                "February 14, 2019",
                "Action, Science Fiction, Adventure",
                "2h 2m",
                "72%",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "poster_alita"
            )
        )

        movies.add(
            MovieEntity(
                2,
                "Aquaman",
                "December 7, 2018",
                "Action, Adventure, Fantasy",
                "2h 23m",
                "69%",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "poster_aquaman"
            )
        )

        movies.add(
            MovieEntity(
                3,
                "Cold Pursuit",
                "February 7, 2019",
                "Action, Crime, Thriller",
                "1h 59m",
                "57%",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "poster_cold_persuit"
            )
        )

        movies.add(
            MovieEntity(
                4,
                "Fantastic Beasts: The Crimes of Grindelwald",
                "November 14, 2018",
                "Adventure, Fantasy, Drama",
                "2h 14m",
                "69%",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "poster_crimes"
            )
        )

        movies.add(
            MovieEntity(
                5,
                "Glass",
                "January 16, 2019",
                "Thriller, Drama, Science Fiction",
                "2h 9m",
                "67%",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "poster_glass"
            )
        )

        movies.add(
            MovieEntity(
                6,
                "How to Train Your Dragon: The Hidden World",
                "January 3, 2019",
                "Animation, Family, Adventure",
                "1h 44m",
                "78%",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "poster_how_to_train"
            )
        )

        movies.add(
            MovieEntity(
                7,
                "Avengers: Infinity War",
                "April 25, 2018",
                "Adventure, Action, Science Fiction",
                "2h 29m",
                "83%",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "poster_infinity_war"
            )
        )

        movies.add(
            MovieEntity(
                8,
                "Ralph Breaks the Internet",
                "November 20, 2018",
                "Family, Animation, Comedy, Adventure",
                "1h 52m",
                "72%",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                "poster_ralph"
            )
        )

        movies.add(
            MovieEntity(
                9,
                "Robin Hood",
                "November 21, 2018",
                "Adventure, Action, Thriller",
                "1h 56m",
                "59%",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "poster_robin_hood"
            )
        )

        movies.add(
            MovieEntity(
                10,
                "Spider-Man: Into the Spider-Verse",
                "December 6, 2018",
                "Action, Adventure, Animation, Science Fiction, Comedy",
                "1h 57m",
                "84%",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "poster_spiderman"
            )
        )

        return movies
    }

    fun generateDummyTvShows(): List<TvShowEntity> {
        val tvShows = ArrayList<TvShowEntity>()

        tvShows.add(
            TvShowEntity(
                1,
                "Arrow",
                "October 10, 2012",
                "Crime, Drama, Mystery, Action & Adventure",
                "42m",
                "66%",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "poster_arrow"
            )
        )

        tvShows.add(
            TvShowEntity(
                2,
                "Dragon Ball",
                "February 26, 1986",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                "25m",
                "81%",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "poster_dragon_ball"
            )
        )

        tvShows.add(
            TvShowEntity(
                3,
                "Fairy Tail",
                "October 12, 2009",
                "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy, Mystery",
                "25m",
                "78%",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "poster_fairytail"
            )
        )

        tvShows.add(
            TvShowEntity(
                4,
                "The Flash",
                "October 7, 2014",
                "Drama, Sci-Fi & Fantasy",
                "44m",
                "77%",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "poster_flash"
            )
        )

        tvShows.add(
            TvShowEntity(
                5,
                "Gotham",
                "September 22, 2014",
                "Drama, Crime, Sci-Fi & Fantasy",
                "43m",
                "75%",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "poster_gotham"
            )
        )

        tvShows.add(
            TvShowEntity(
                6,
                "Marvel's Iron Fist",
                "March 17, 2017",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "55m",
                "66%",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "poster_iron_fist"
            )
        )

        tvShows.add(
            TvShowEntity(
                7,
                "Naruto Shippūden",
                "February 15, 2007",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                "25m",
                "86%",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "poster_naruto_shipudden"
            )
        )

        tvShows.add(
            TvShowEntity(
                8,
                "Supergirl",
                "October 26, 2015",
                "Drama, Sci-Fi & Fantasy, Action & Adventure",
                "42m",
                "73%",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "poster_supergirl"
            )
        )

        tvShows.add(
            TvShowEntity(
                9,
                "The Simpsons",
                "December 17, 1989",
                "Family, Animation, Comedy",
                "22m",
                "78%",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "poster_the_simpson"
            )
        )

        tvShows.add(
            TvShowEntity(
                10,
                "The Walking Dead",
                "October 31, 2010",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "42m",
                "81%",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "poster_the_walking_dead"
            )
        )

        return tvShows
    }

    fun generateDummyMoviesResponse(): List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()
        movies.add(
                MovieResponse(
                        1,
                        "Alita: Battle Angel",
                        "February 14, 2019",
                        "Action, Science Fiction, Adventure",
                        "2h 2m",
                        "72%",
                        "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                        "poster_alita"
                )
        )

        movies.add(
                MovieResponse(
                        2,
                        "Aquaman",
                        "December 7, 2018",
                        "Action, Adventure, Fantasy",
                        "2h 23m",
                        "69%",
                        "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                        "poster_aquaman"
                )
        )

        movies.add(
                MovieResponse(
                        3,
                        "Cold Pursuit",
                        "February 7, 2019",
                        "Action, Crime, Thriller",
                        "1h 59m",
                        "57%",
                        "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                        "poster_cold_persuit"
                )
        )

        movies.add(
                MovieResponse(
                        4,
                        "Fantastic Beasts: The Crimes of Grindelwald",
                        "November 14, 2018",
                        "Adventure, Fantasy, Drama",
                        "2h 14m",
                        "69%",
                        "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                        "poster_crimes"
                )
        )

        movies.add(
                MovieResponse(
                        5,
                        "Glass",
                        "January 16, 2019",
                        "Thriller, Drama, Science Fiction",
                        "2h 9m",
                        "67%",
                        "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                        "poster_glass"
                )
        )

        movies.add(
                MovieResponse(
                        6,
                        "How to Train Your Dragon: The Hidden World",
                        "January 3, 2019",
                        "Animation, Family, Adventure",
                        "1h 44m",
                        "78%",
                        "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                        "poster_how_to_train"
                )
        )

        movies.add(
                MovieResponse(
                        7,
                        "Avengers: Infinity War",
                        "April 25, 2018",
                        "Adventure, Action, Science Fiction",
                        "2h 29m",
                        "83%",
                        "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                        "poster_infinity_war"
                )
        )

        movies.add(
                MovieResponse(
                        8,
                        "Ralph Breaks the Internet",
                        "November 20, 2018",
                        "Family, Animation, Comedy, Adventure",
                        "1h 52m",
                        "72%",
                        "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                        "poster_ralph"
                )
        )

        movies.add(
                MovieResponse(
                        9,
                        "Robin Hood",
                        "November 21, 2018",
                        "Adventure, Action, Thriller",
                        "1h 56m",
                        "59%",
                        "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                        "poster_robin_hood"
                )
        )

        movies.add(
                MovieResponse(
                        10,
                        "Spider-Man: Into the Spider-Verse",
                        "December 6, 2018",
                        "Action, Adventure, Animation, Science Fiction, Comedy",
                        "1h 57m",
                        "84%",
                        "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                        "poster_spiderman"
                )
        )

        return movies
    }

    fun generateDummyTvShowsResponse(): List<TvShowResponse> {
        val tvShows = ArrayList<TvShowResponse>()

        tvShows.add(
                TvShowResponse(
                        1,
                        "Arrow",
                        "October 10, 2012",
                        "Crime, Drama, Mystery, Action & Adventure",
                        "42m",
                        "66%",
                        "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                        "poster_arrow"
                )
        )

        tvShows.add(
                TvShowResponse(
                        2,
                        "Dragon Ball",
                        "February 26, 1986",
                        "Animation, Action & Adventure, Sci-Fi & Fantasy",
                        "25m",
                        "81%",
                        "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                        "poster_dragon_ball"
                )
        )

        tvShows.add(
                TvShowResponse(
                        3,
                        "Fairy Tail",
                        "October 12, 2009",
                        "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy, Mystery",
                        "25m",
                        "78%",
                        "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                        "poster_fairytail"
                )
        )

        tvShows.add(
                TvShowResponse(
                        4,
                        "The Flash",
                        "October 7, 2014",
                        "Drama, Sci-Fi & Fantasy",
                        "44m",
                        "77%",
                        "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                        "poster_flash"
                )
        )

        tvShows.add(
                TvShowResponse(
                        5,
                        "Gotham",
                        "September 22, 2014",
                        "Drama, Crime, Sci-Fi & Fantasy",
                        "43m",
                        "75%",
                        "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                        "poster_gotham"
                )
        )

        tvShows.add(
                TvShowResponse(
                        6,
                        "Marvel's Iron Fist",
                        "March 17, 2017",
                        "Action & Adventure, Drama, Sci-Fi & Fantasy",
                        "55m",
                        "66%",
                        "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                        "poster_iron_fist"
                )
        )

        tvShows.add(
                TvShowResponse(
                        7,
                        "Naruto Shippūden",
                        "February 15, 2007",
                        "Animation, Action & Adventure, Sci-Fi & Fantasy",
                        "25m",
                        "86%",
                        "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                        "poster_naruto_shipudden"
                )
        )

        tvShows.add(
                TvShowResponse(
                        8,
                        "Supergirl",
                        "October 26, 2015",
                        "Drama, Sci-Fi & Fantasy, Action & Adventure",
                        "42m",
                        "73%",
                        "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                        "poster_supergirl"
                )
        )

        tvShows.add(
                TvShowResponse(
                        9,
                        "The Simpsons",
                        "December 17, 1989",
                        "Family, Animation, Comedy",
                        "22m",
                        "78%",
                        "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                        "poster_the_simpson"
                )
        )

        tvShows.add(
                TvShowResponse(
                        10,
                        "The Walking Dead",
                        "October 31, 2010",
                        "Action & Adventure, Drama, Sci-Fi & Fantasy",
                        "42m",
                        "81%",
                        "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                        "poster_the_walking_dead"
                )
        )

        return tvShows
    }
}