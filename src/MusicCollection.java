import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

class MusicCollection {
    public static void main(String[] args) {
        List<Song> songs = List.of(
                new Song("Nothing Else Matters", 386, "Metallica", Song.Genre.METAL),
                new Song("No One", 248, "Alicia Keys", Song.Genre.POP),
                new Song("Nothing Else Matters", 386, "Metallica", Song.Genre.METAL),
                new Song("Believer", 216, "Imagine Dragons", Song.Genre.ROCK),
                new Song("Fear of The Dark", 438, "Iron Maiden", Song.Genre.METAL),
                new Song("Enter Sandman", 346, "Metallica", Song.Genre.METAL),
                new Song("The Unforgiven", 348, "Metallica", Song.Genre.METAL),
                new Song("Girl on Fire", 404, "Alicia Keys", Song.Genre.POP)
        );
        Song.Genre genre = Song.Genre.METAL;
        String author = "Metallica";
        playlistTimeByGenre(songs,genre);
        amountOfSongsOfAuthorInList(songs, author);
        songsOutsideOfGenre(songs,genre);
    }

    private static void songsOutsideOfGenre(List<Song> songs, Song.Genre genre) {
        System.out.println("Songs outside of : " + genre + " genre: ");
        Set<Song> collection = songs.stream()
                .filter(song -> !song.getGenre().equals(genre))
                .collect(Collectors.toSet());
        collection.stream().forEach(System.out::println);
    }

    private static void amountOfSongsOfAuthorInList(List<Song> songs, String author) {
        System.out.println("amount: " + author + " : " +
                        songs.stream()
                                .filter(song -> song.getArtist().toLowerCase().equals(author.toLowerCase()))
                                .count());
    }

    private static void playlistTimeByGenre(List<Song> songs, Song.Genre genre) {
        System.out.println("Sum of time for songs from: " + genre + " genre: " +
                songs.stream()
                        .filter(song -> song.getGenre() == genre)
                        .mapToInt(Song::getLength).sum() / 60 + " mins");
    }

}