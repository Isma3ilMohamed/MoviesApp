package com.udacity.moviesapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by The Dev Wolf on 07-03-2018.
 */

public class Movie {

    /**
     * page : 1
     * total_results : 19616
     * total_pages : 981
     * results : [{"vote_count":6401,"id":269149,"video":false,"vote_average":7.7,"title":"Zootopia","popularity":435.037389,"poster_path":"/sM33SANp9z6rXW8Itn7NnG1GOEs.jpg","original_language":"en","original_title":"Zootopia","genre_ids":[16,12,10751,35],"backdrop_path":"/mhdeE1yShHTaDbJVdWyTlzFvNkr.jpg","adult":false,"overview":"Determined to prove herself, Officer Judy Hopps, the first bunny on Zootopia's police force, jumps at the chance to crack her first case - even if it means partnering with scam-artist fox Nick Wilde to solve the mystery.","release_date":"2016-02-11"},{"vote_count":7235,"id":198663,"video":false,"vote_average":7,"title":"The Maze Runner","popularity":388.48387,"poster_path":"/coss7RgL0NH6g4fC2s5atvf3dFO.jpg","original_language":"en","original_title":"The Maze Runner","genre_ids":[28,9648,878,53],"backdrop_path":"/lkOZcsXcOLZYeJ2YxJd3vSldvU4.jpg","adult":false,"overview":"Set in a post-apocalyptic world, young Thomas is deposited in a community of boys after his memory is erased, soon learning they're all trapped in a maze that will require him to join forces with fellow \u201crunners\u201d for a shot at escape.","release_date":"2014-09-10"},{"vote_count":2882,"id":343668,"video":false,"vote_average":7,"title":"Kingsman: The Golden Circle","popularity":293.206262,"poster_path":"/34xBL6BXNYFqtHO9zhcgoakS4aP.jpg","original_language":"en","original_title":"Kingsman: The Golden Circle","genre_ids":[28,12,35],"backdrop_path":"/uExPmkOHJySrbJyJDJylHDqaT58.jpg","adult":false,"overview":"When an attack on the Kingsman headquarters takes place and a new villain rises, Eggsy and Merlin are forced to work together with the American agency known as the Statesman to save the world.","release_date":"2017-09-20"},{"vote_count":4253,"id":339403,"video":false,"vote_average":7.4,"title":"Baby Driver","popularity":195.960248,"poster_path":"/dN9LbVNNZFITwfaRjl4tmwGWkRg.jpg","original_language":"en","original_title":"Baby Driver","genre_ids":[28,80],"backdrop_path":"/goCvLSUFz0p7k8R10Hv4CVh3EQv.jpg","adult":false,"overview":"After being coerced into working for a crime boss, a young getaway driver finds himself taking part in a heist doomed to fail.","release_date":"2017-06-28"},{"vote_count":8797,"id":209112,"video":false,"vote_average":5.7,"title":"Batman v Superman: Dawn of Justice","popularity":169.116453,"poster_path":"/cGOPbv9wA5gEejkUN892JrveARt.jpg","original_language":"en","original_title":"Batman v Superman: Dawn of Justice","genre_ids":[28,12,14],"backdrop_path":"/vsjBeMPZtyB7yNsYY56XYxifaQZ.jpg","adult":false,"overview":"Fearing the actions of a god-like Super Hero left unchecked, Gotham City\u2019s own formidable, forceful vigilante takes on Metropolis\u2019s most revered, modern-day savior, while the world wrestles with what sort of hero it really needs. And with Batman and Superman at war with one another, a new threat quickly arises, putting mankind in greater danger than it\u2019s ever known before.","release_date":"2016-03-23"},{"vote_count":3056,"id":258489,"video":false,"vote_average":5.6,"title":"The Legend of Tarzan","popularity":162.273507,"poster_path":"/6FxOPJ9Ysilpq0IgkrMJ7PubFhq.jpg","original_language":"en","original_title":"The Legend of Tarzan","genre_ids":[28,12],"backdrop_path":"/pWNBPN8ghaKtGLcQBMwNyM32Wbm.jpg","adult":false,"overview":"Tarzan, having acclimated to life in London, is called back to his former home in the jungle to investigate the activities at a mining encampment.","release_date":"2016-06-29"},{"vote_count":1892,"id":396422,"video":false,"vote_average":6.4,"title":"Annabelle: Creation","popularity":161.561862,"poster_path":"/tb86j8jVCVsdZnzf8I6cIi65IeM.jpg","original_language":"en","original_title":"Annabelle: Creation","genre_ids":[27,9648,53],"backdrop_path":"/3L5gfIKt2RK9vnCiLgWTAzkhQWC.jpg","adult":false,"overview":"Several years after the tragic death of their little girl, a dollmaker and his wife welcome a nun and several girls from a shuttered orphanage into their home, soon becoming the target of the dollmaker's possessed creation, Annabelle.","release_date":"2017-08-03"},{"vote_count":442,"id":460793,"video":false,"vote_average":5.9,"title":"Olaf's Frozen Adventure","popularity":156.849516,"poster_path":"/47pLZ1gr63WaciDfHCpmoiXJlVr.jpg","original_language":"en","original_title":"Olaf's Frozen Adventure","genre_ids":[12,16,35,10751,14,10402],"backdrop_path":"/9K4QqQZg4TVXcxBGDiVY4Aey3Rn.jpg","adult":false,"overview":"Olaf is on a mission to harness the best holiday traditions for Anna, Elsa, and Kristoff.","release_date":"2017-10-27"},{"vote_count":7476,"id":321612,"video":false,"vote_average":6.8,"title":"Beauty and the Beast","popularity":128.131566,"poster_path":"/tWqifoYuwLETmmasnGHO7xBjEtt.jpg","original_language":"en","original_title":"Beauty and the Beast","genre_ids":[10751,14,10749],"backdrop_path":"/6aUWe0GSl69wMTSWWexsorMIvwU.jpg","adult":false,"overview":"A live-action adaptation of Disney's version of the classic tale of a cursed prince and a beautiful young woman who helps him break the spell.","release_date":"2017-03-16"},{"vote_count":5685,"id":68726,"video":false,"vote_average":6.7,"title":"Pacific Rim","popularity":111.800631,"poster_path":"/sCJEwEShZvruTpQ2a4yiX3Q9EyZ.jpg","original_language":"en","original_title":"Pacific Rim","genre_ids":[28,878,12],"backdrop_path":"/iB0RsWVoOXzicPi2Yy5xmTYMbho.jpg","adult":false,"overview":"When legions of monstrous creatures, known as Kaiju, started rising from the sea, a war began that would take millions of lives and consume humanity's resources for years on end. To combat the giant Kaiju, a special type of weapon was devised: massive robots, called Jaegers, which are controlled simultaneously by two pilots whose minds are locked in a neural bridge. But even the Jaegers are proving nearly defenseless in the face of the relentless Kaiju. On the verge of defeat, the forces defending mankind have no choice but to turn to two unlikely heroes\u2014a washed-up former pilot (Charlie Hunnam) and an untested trainee (Rinko Kikuchi)\u2014who are teamed to drive a legendary but seemingly obsolete Jaeger from the past. Together, they stand as mankind's last hope against the mounting apocalypse.","release_date":"2013-07-11"},{"vote_count":259,"id":347882,"video":false,"vote_average":5.2,"title":"Sleight","popularity":111.79932,"poster_path":"/wridRvGxDqGldhzAIh3IcZhHT5F.jpg","original_language":"en","original_title":"Sleight","genre_ids":[18,53,28,878],"backdrop_path":"/2SEgJ0mHJ7TSdVDbkGU061tR33K.jpg","adult":false,"overview":"A young street magician is left to take care of his little sister after his mother's passing and turns to drug dealing in the Los Angeles party scene to keep a roof over their heads. When he gets into trouble with his supplier, his sister is kidnapped and he is forced to rely on both his sleight of hand and brilliant mind to save her.","release_date":"2017-04-28"},{"vote_count":42,"id":379220,"video":false,"vote_average":5.9,"title":"No Filter","popularity":109.761411,"poster_path":"/cISuCIaPdwjJ8YJhBipdslltKl9.jpg","original_language":"es","original_title":"Sin Filtro","genre_ids":[35],"backdrop_path":"/4GQnO108sllO8PMRsvqLTTOe3fL.jpg","adult":false,"overview":"When a woman visits a Chinese doctor, she discovers her pain is due to pent-up rage, and the only cure is to fully express herself, whatever may come.","release_date":"2016-01-07"},{"vote_count":12,"id":394823,"video":false,"vote_average":5.6,"title":"Robby and Toby's Fantastic Voyager","popularity":109.664501,"poster_path":"/ssCEE0bfj5gawzwZeGfqrGQtU3f.jpg","original_language":"de","original_title":"Robbi, Tobbi und das Fliewatüüt","genre_ids":[12,10751],"backdrop_path":"/gZF2EfM8ov834pCzRpt1xt01SUy.jpg","adult":false,"overview":"One day, robot Robby enters into a life of the most creative little boy, Toby. Robby had been separated from his robot parents when his spaceship crashed. Toby decides to offer his help and the two of them become friends.","release_date":"2016-12-01"},{"vote_count":7293,"id":240832,"video":false,"vote_average":6.2,"title":"Lucy","popularity":105.335927,"poster_path":"/rwn876MeqienhOVSSjtUPnwxn0Z.jpg","original_language":"en","original_title":"Lucy","genre_ids":[28,878],"backdrop_path":"/eCgIoGvfNXrbSiQGqQHccuHjQHm.jpg","adult":false,"overview":"A woman, accidentally caught in a dark deal, turns the tables on her captors and transforms into a merciless warrior evolved beyond human logic.","release_date":"2014-07-25"},{"vote_count":191,"id":350312,"video":false,"vote_average":7,"title":"Baahubali 2: The Conclusion","popularity":105.1682,"poster_path":"/sXf30F2HFpsFPXlNz7jpOySSV9I.jpg","original_language":"te","original_title":"Baahubali 2: The Conclusion","genre_ids":[28,12,36,10752],"backdrop_path":"/yCRYYGldFGVa4cmZVpTVCRQMfjA.jpg","adult":false,"overview":"When Mahendra, the son of Bahubali, learns about his heritage, he begins to look for answers. His story is juxtaposed with past events that unfolded in the Mahishmati Kingdom.","release_date":"2017-04-27"},{"vote_count":87,"id":426284,"video":false,"vote_average":6.6,"title":"Blade of the Immortal","popularity":105.104868,"poster_path":"/bFaxg006Dt6J1k7qa7a5YuqbAhe.jpg","original_language":"ja","original_title":"無限の住人","genre_ids":[28,18],"backdrop_path":"/wtzJihFG4aBTat6QG9BoOWud7rG.jpg","adult":false,"overview":"Manji, a highly skilled samurai, becomes cursed with immortality after a legendary battle. Haunted by the brutal murder of his sister, Manji knows that only fighting evil will regain his soul. He promises to help a young girl named Rin avenge her parents, who were killed by a group of master swordsmen led by ruthless warrior Anotsu. The mission will change Manji in ways he could never imagine.","release_date":"2017-04-29"},{"vote_count":7209,"id":259316,"video":false,"vote_average":7.2,"title":"Fantastic Beasts and Where to Find Them","popularity":101.887016,"poster_path":"/gri0DDxsERr6B2sOR1fGLxLpSLx.jpg","original_language":"en","original_title":"Fantastic Beasts and Where to Find Them","genre_ids":[12,10751,14],"backdrop_path":"/6I2tPx6KIiBB4TWFiWwNUzrbxUn.jpg","adult":false,"overview":"In 1926, Newt Scamander arrives at the Magical Congress of the United States of America with a magically expanded briefcase, which houses a number of dangerous creatures and their habitats. When the creatures escape from the briefcase, it sends the American wizarding authorities after Newt, and threatens to strain even further the state of magical and non-magical relations.","release_date":"2016-11-16"},{"vote_count":3704,"id":254128,"video":false,"vote_average":6,"title":"San Andreas","popularity":99.103774,"poster_path":"/qey0tdcOp9kCDdEZuJ87yE3crSe.jpg","original_language":"en","original_title":"San Andreas","genre_ids":[28,18,53],"backdrop_path":"/cUfGqafAVQkatQ7N4y08RNV3bgu.jpg","adult":false,"overview":"In the aftermath of a massive earthquake in California, a rescue-chopper pilot makes a dangerous journey across the state in order to rescue his estranged daughter.","release_date":"2015-05-27"},{"vote_count":4156,"id":283366,"video":false,"vote_average":6.6,"title":"Miss Peregrine's Home for Peculiar Children","popularity":96.840239,"poster_path":"/tzYkC0vqX8Dokuwynhz1lnWWgWT.jpg","original_language":"en","original_title":"Miss Peregrine's Home for Peculiar Children","genre_ids":[18,14,12],"backdrop_path":"/9BVHn78oQcFCRd4M3u3NT7OrhTk.jpg","adult":false,"overview":"A teenager finds himself transported to an island where he must help protect a group of orphans with special powers from creatures intent on destroying them.","release_date":"2016-09-28"},{"vote_count":3033,"id":273481,"video":false,"vote_average":7.2,"title":"Sicario","popularity":96.394335,"poster_path":"/p2SdfGmQRaw8xhFbexlHL7srMM8.jpg","original_language":"en","original_title":"Sicario","genre_ids":[28,80,18,9648,53],"backdrop_path":"/kG5Zn9z20L2O7Jo2Y2jykOMh60v.jpg","adult":false,"overview":"A young female FBI agent joins a secret CIA operation to take down a Mexican cartel boss, a job that ends up pushing her ethical and moral values to the limit.","release_date":"2015-09-17"}]
     */

    private int page;
    private int total_results;
    private int total_pages;
    private List<MovieDetail> results;


    public Movie(int page, int total_results, int total_pages, List<MovieDetail> results) {
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<MovieDetail> getResults() {
        return results;
    }

    public void setResults(List<MovieDetail> results) {
        this.results = results;
    }

    public static class MovieDetail implements Parcelable {
        /**
         * vote_count : 6401
         * id : 269149
         * video : false
         * vote_average : 7.7
         * title : Zootopia
         * popularity : 435.037389
         * poster_path : /sM33SANp9z6rXW8Itn7NnG1GOEs.jpg
         * original_language : en
         * original_title : Zootopia
         * genre_ids : [16,12,10751,35]
         * backdrop_path : /mhdeE1yShHTaDbJVdWyTlzFvNkr.jpg
         * adult : false
         * overview : Determined to prove herself, Officer Judy Hopps, the first bunny on Zootopia's police force, jumps at the chance to crack her first case - even if it means partnering with scam-artist fox Nick Wilde to solve the mystery.
         * release_date : 2016-02-11
         */

        private int vote_count;
        private int id;
        private boolean video;
        private double vote_average;
        private String title;
        private double popularity;
        private String poster_path;
        private String original_language;
        private String original_title;
        private String backdrop_path;
        private boolean adult;
        private String overview;
        private String release_date;
        private List<Integer> genre_ids;


        public MovieDetail(int vote_count, int id, boolean video, double vote_average, String title, double popularity, String poster_path, String original_language, String original_title, String backdrop_path, boolean adult, String overview, String release_date, List<Integer> genre_ids) {
            this.vote_count = vote_count;
            this.id = id;
            this.video = video;
            this.vote_average = vote_average;
            this.title = title;
            this.popularity = popularity;
            this.poster_path = poster_path;
            this.original_language = original_language;
            this.original_title = original_title;
            this.backdrop_path = backdrop_path;
            this.adult = adult;
            this.overview = overview;
            this.release_date = release_date;
            this.genre_ids = genre_ids;
        }

        protected MovieDetail(Parcel in) {
            vote_count = in.readInt();
            id = in.readInt();
            video = in.readByte() != 0;
            vote_average = in.readDouble();
            title = in.readString();
            popularity = in.readDouble();
            poster_path = in.readString();
            original_language = in.readString();
            original_title = in.readString();
            backdrop_path = in.readString();
            adult = in.readByte() != 0;
            overview = in.readString();
            release_date = in.readString();
        }

        public static final Creator<MovieDetail> CREATOR = new Creator<MovieDetail>() {
            @Override
            public MovieDetail createFromParcel(Parcel in) {
                return new MovieDetail(in);
            }

            @Override
            public MovieDetail[] newArray(int size) {
                return new MovieDetail[size];
            }
        };

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public double getVote_average() {
            return vote_average;
        }

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public boolean isAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public List<Integer> getGenre_ids() {
            return genre_ids;
        }

        public void setGenre_ids(List<Integer> genre_ids) {
            this.genre_ids = genre_ids;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(vote_count);
            parcel.writeInt(id);
            parcel.writeByte((byte) (video ? 1 : 0));
            parcel.writeDouble(vote_average);
            parcel.writeString(title);
            parcel.writeDouble(popularity);
            parcel.writeString(poster_path);
            parcel.writeString(original_language);
            parcel.writeString(original_title);
            parcel.writeString(backdrop_path);
            parcel.writeByte((byte) (adult ? 1 : 0));
            parcel.writeString(overview);
            parcel.writeString(release_date);
        }
    }
}
