// package com.example.myFirstApp;
// import static com.mongodb.client.model.Filters.eq;
// import org.bson.Document;

// import com.mongodb.client.MongoClient;
// import com.mongodb.client.MongoClients;
// import com.mongodb.client.MongoCollection;
// import com.mongodb.client.MongoDatabase;

// public class MongoClientConnectionExample {
//     public static void main( String[] args ) {

//         // Replace the placeholder with your MongoDB deployment's connection string
//         String uri = "mongodb+srv://jinadtope66:Aderinto2@cluster0.jph7qff.mongodb.net/java_db?retryWrites=true&w=majority&appName=Cluster0";

//         try (MongoClient mongoClient = MongoClients.create(uri)) {
//             MongoDatabase database = mongoClient.getDatabase("sample_mflix");
//             MongoCollection<Document> collection = database.getCollection("movies");

//             Document doc = collection.find(eq("title", "Back to the Future")).first();
//             if (doc != null) {
//                 System.out.println(doc.toJson());
//             } else {
//                 System.out.println("No matching documents found.");
               
//             }
//         }
//     }
// }


// // import com.mongodb.ConnectionString;
// // import com.mongodb.MongoClientSettings;
// // import com.mongodb.MongoException;
// // import com.mongodb.ServerApi;
// // import com.mongodb.ServerApiVersion;
// // import com.mongodb.client.MongoClient;
// // import com.mongodb.client.MongoClients;
// // import com.mongodb.client.MongoDatabase;
// // import org.bson.Document;

// // public class MongoClientConnectionExample {
// //     public static void main(String[] args) {
// //         // Use the standard mongodb protocol to avoid DNS TXT lookup issues
        
// //         ServerApi serverApi = ServerApi.builder()
// //                 .version(ServerApiVersion.V1)
// //                 .build();

// //         MongoClientSettings settings = MongoClientSettings.builder()
// //                 .applyConnectionString(new ConnectionString(connectionString))
// //                 .serverApi(serverApi)
// //                 .build();

// //         // Create a new client and connect to the server
// //         try (MongoClient mongoClient = MongoClients.create(settings)) {
// //             try {
// //                 // Send a ping to confirm a successful connection
// //                 MongoDatabase database = mongoClient.getDatabase("admin");
// //                 database.runCommand(new Document("ping", 1));
// //                 System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
// //             } catch (MongoException e) {
// //                 System.err.println("Failed to connect to MongoDB: " + e.getMessage());
// //                 e.printStackTrace();
// //             }
// //         } catch (Exception e) {
// //             System.err.println("An unexpected error occurred: " + e.getMessage());
// //             e.printStackTrace();
// //         }
// //     }
// // }

        