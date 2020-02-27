import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.*;

public class JsonMerger {
    //List of file names to merge
    public static List<String> fileNames = new ArrayList<>(
          Arrays.asList( "./Disqus file/6971761113_20181015141058.txt", "./Disqus file/6971761113_20181015144051.txt",
                  "./Disqus file/6971761113_20181015151911.txt",
                  "./Disqus file/6972065528_20181016162626.txt",
                  "./Disqus file/6972065528_20181102150609.txt",
                  "./Disqus file/6972065528_20181113174050.txt",
                  "./Disqus file/7036566375_20181111142725.txt",
                  "./Disqus file/7036566375_20181113182947.txt",
                  "./Disqus file/7036566375_20181114123440.txt",
                  "./Disqus file/7036771832_20181111212138.txt",
                  "./Disqus file/7036771832_20181113012258.txt",
                  "./Disqus file/7036771832_20181113212716.txt",
                  "./Disqus file/7038107572_20181112142536.txt",
                  "./Disqus file/7038107572_20181113212935.txt",
                  "./Disqus file/7038107572_20181113213503.txt"));

    //Read in the file as a string
    public static String fileToString(String fileName) throws FileNotFoundException {
        Scanner in = new Scanner(new File(fileName));
        String result = "";

        while(in.hasNextLine()){
            result += in.nextLine();
        }

        return result;
    }

    //Create a list of all the json file strings
    public static List<String> filesToListOfStrings(List<String> fileNames) throws FileNotFoundException {
        List<String> jsonStrings = new ArrayList<>();

        for(int i = 0; i < fileNames.size(); i ++){
            String s = fileToString(fileNames.get(i));
            jsonStrings.add(s);
        }

        return jsonStrings;
    }

    //Turn JSON string into a JSON object
    public static Example stringToJSON(String s){
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new StringReader(s));
        reader.setLenient(true);

        Example ex = gson.fromJson(reader, Example.class);

        return ex;
    }

    //Compile list of strings into a list of JSON objects
    public static List<List<Response>> stringListToJSONList(List<String> jsonStrings){
        List<List<Response>> jsonObjects = new ArrayList<>();

        for(int i = 0; i < jsonStrings.size(); i ++){
            Example ex = stringToJSON(jsonStrings.get(i));
            List<Response> resp = ex.getResponse();
            jsonObjects.add(resp);

        }

        return jsonObjects;
    }

    //Finds matching Ids and then makes changes if necessary. r1 is the base element, r2 is the new element
    //Adds remaining elements in r2 to r1 if they are not already included
    public static void mergeJsonIntoBase(List<Response> r1,  List<Response> r2){
        //List of json objects in the new but not old json
        List<String> toAdd = new ArrayList<>();
        for(int i = 0; i < r1.size(); i ++){
            String r1ID = r1.get(i).getId();
            for(int j = 0; j < r2.size(); j ++){
                String r2ID = r2.get(j).getId();
                if(r1ID.equals(r2ID)){
                    compareJson(r1.get(i), r2.get(j));
                }else{
                    if (!toAdd.contains(r2ID)) {
                        toAdd.add(r2ID);
                    }
                }
            }
        }
        //Add all new elements into the base element
        List<Response> remainderToAdd = getElementListById(toAdd, r2);

        for(Response r: remainderToAdd){
            r1.add(r);
        }
    }

    //Make a list of Responses, based on a list of IDs
    public static List<Response> getElementListById(List<String> toAdd, List<Response> newJson){
        List<Response> jsonToAdd = new ArrayList<>();
        for(int i = 0; i < newJson.size(); i++){
            String rId = newJson.get(i).id;
            if(toAdd.contains(rId)){
                jsonToAdd.add(newJson.get(i));
            }

        }
        return jsonToAdd;
    }

    //Compares two responses and changes an object to reflect the changes in the second
    public static void compareJson(Response r1, Response r2){
        //Compare in response
        r1.editableUntil     = r1.editableUntil    .equals(r2.editableUntil    )    ?    r1.editableUntil     :  r2.editableUntil    ;
        r1.dislikes          = r1.dislikes             == r2.dislikes               ?    r1.dislikes          :  r2.dislikes         ;
        r1.numReports        = r1.numReports           == r2.numReports             ?    r1.numReports        :  r2.numReports       ;
        r1.likes             = r1.likes                == r2.likes                  ?    r1.likes             :  r2.likes            ;
        r1.message           = r1.message          .equals(r2.message          )    ?    r1.message           :  r2.message          ;
        r1.id                = r1.id               .equals(r2.id               )    ?    r1.id                :  r2.id               ;
        r1.createdAt         = r1.createdAt        .equals(r2.createdAt        )    ?    r1.createdAt         :  r2.createdAt        ;
        r1.media             = r1.media            .equals(r2.media            )    ?    r1.media             :  r2.media            ;
        r1.isSpam            = r1.isSpam           .equals(r2.isSpam           )    ?    r1.isSpam            :  r2.isSpam           ;
        r1.isDeletedByAuthor = r1.isDeletedByAuthor.equals(r2.isDeletedByAuthor)    ?    r1.isDeletedByAuthor :  r2.isDeletedByAuthor;
        r1.isDeleted         = r1.isDeleted        .equals(r2.isDeleted        )    ?    r1.isDeleted         :  r2.isDeleted        ;

        try{
          r1.parent            = r1.parent           .equals(r2.parent           )    ?    r1.parent            :  r2.parent         ;
        } catch(NullPointerException e){
           r1.parent  = r2.parent != null ?  r2.parent: r1.parent;
        }

        r1.isApproved        = r1.isApproved       .equals(r2.isApproved       )    ?    r1.isApproved        :  r2.isApproved       ;
        r1.isFlagged         = r1.isFlagged        .equals(r2.isFlagged        )    ?    r1.isFlagged         :  r2.isFlagged        ;
        r1.rawMessage        = r1.rawMessage       .equals(r2.rawMessage       )    ?    r1.rawMessage        :  r2.rawMessage       ;
        r1.isHighlighted     = r1.isHighlighted    .equals(r2.isHighlighted    )    ?    r1.isHighlighted     :  r2.isHighlighted    ;
        r1.canVote           = r1.canVote          .equals(r2.canVote          )    ?    r1.canVote           :  r2.canVote          ;
        r1.thread            = r1.thread           .equals(r2.thread           )    ?    r1.thread            :  r2.thread           ;
        r1.forum             = r1.forum            .equals(r2.forum            )    ?    r1.forum             :  r2.forum            ;
        r1.points            = r1.points           .equals(r2.points           )    ?    r1.points            :  r2.points           ;
        r1.moderationLabels  = r1.moderationLabels .equals(r2.moderationLabels )    ?    r1.moderationLabels  :  r2.moderationLabels ;
        r1.isEdited          = r1.isEdited         .equals(r2.isEdited         )    ?    r1.isEdited          :  r2.isEdited         ;
        r1.sb                = r1.sb               .equals(r2.sb               )    ?    r1.sb                :  r2.sb               ;

        //Compare in Author
        r1.author.profileUrl              = r1.author.profileUrl              .equals(r2.author.profileUrl             )    ?    r1.author.profileUrl               :  r2.author.profileUrl             ;

        try{
            r1.author.disable3rdPartyTrackers = r1.author.disable3rdPartyTrackers .equals(r2.author.disable3rdPartyTrackers)    ?    r1.author.disable3rdPartyTrackers  :  r2.author.disable3rdPartyTrackers;
        } catch(NullPointerException e){
            r1.author.disable3rdPartyTrackers  = r2.author.disable3rdPartyTrackers != null ?  r2.author.disable3rdPartyTrackers: r1.author.disable3rdPartyTrackers;
        }

        try{
            r1.author.joinedAt                = r1.author.joinedAt                .equals(r2.author.joinedAt               )    ?    r1.author.joinedAt                 :  r2.author.joinedAt               ;
        } catch(NullPointerException e){
            r1.author.joinedAt  = r2.author.joinedAt != null ?  r2.author.joinedAt: r1.author.joinedAt;
        }

        try{
            r1.author.about                   = r1.author.about                   .equals(r2.author.about                  )    ?    r1.author.about                    :  r2.author.about                  ;
        } catch(NullPointerException e){
            r1.author.about  = r2.author.about != null ?  r2.author.about: r1.author.about;
        }

        try{
            r1.author.isPrivate               = r1.author.isPrivate               .equals(r2.author.isPrivate              )    ?    r1.author.isPrivate                :  r2.author.isPrivate              ;
        } catch(NullPointerException e){
            r1.author.isPrivate  = r2.author.isPrivate != null ?  r2.author.isPrivate: r1.author.isPrivate;
        }

        r1.author.url                     = r1.author.url                     .equals(r2.author.url                    )    ?    r1.author.url                      :  r2.author.url                    ;
        r1.author.isAnonymous             = r1.author.isAnonymous             .equals(r2.author.isAnonymous            )    ?    r1.author.isAnonymous              :  r2.author.isAnonymous            ;

        try{
            r1.author.isPowerContributor      = r1.author.isPowerContributor      .equals(r2.author.isPowerContributor     )    ?    r1.author.isPowerContributor       :  r2.author.isPowerContributor     ;
        } catch(NullPointerException e){
            r1.author.isPowerContributor  = r2.author.isPowerContributor != null ?  r2.author.isPowerContributor: r1.author.isPowerContributor;
        }

        try{
            r1.author.isPrimary               = r1.author.isPrimary               .equals(r2.author.isPrimary              )    ?    r1.author.isPrimary                :  r2.author.isPrimary              ;
        } catch(NullPointerException e){
            r1.author.isPrimary  = r2.author.isPrimary != null ?  r2.author.isPrimary: r1.author.isPrimary;
        }

        r1.author.name                    = r1.author.name                    .equals(r2.author.name                   )    ?    r1.author.name                     :  r2.author.name                   ;

        try{
            r1.author.location                = r1.author.location                .equals(r2.author.location               )    ?    r1.author.location                 :  r2.author.location               ;
        } catch(NullPointerException e){
            r1.author.location  = r2.author.location != null ?  r2.author.location: r1.author.location;
        }

        try{
            r1.author.id                      = r1.author.id                      .equals(r2.author.id                     )    ?    r1.author.id                       :  r2.author.id                     ;
        } catch(NullPointerException e){
            r1.author.id  = r2.author.id != null ?  r2.author.id: r1.author.id;
        }
        r1.author.signedUrl               = r1.author.signedUrl               .equals(r2.author.signedUrl              )    ?    r1.author.signedUrl                :  r2.author.signedUrl              ;

        try{
            r1.author.username                      = r1.author.username                      .equals(r2.author.username                     )    ?    r1.author.username                       :  r2.author.username                     ;
        } catch(NullPointerException e){
            r1.author.username  = r2.author.username != null ?  r2.author.username: r1.author.username;
        }

        //Compare in Avatar
        r1.author.avatar.cache     = r1.author.avatar.cache     .equals(r2.author.avatar.cache    )    ?    r1.author.avatar.cache      :  r2.author.avatar.cache    ;

        try{
            r1.author.avatar.isCustom  = r1.author.avatar.isCustom  .equals(r2.author.avatar.isCustom )    ?    r1.author.avatar.isCustom   :  r2.author.avatar.isCustom ;
        } catch(NullPointerException e){
            r1.author.avatar.isCustom  = r2.author.avatar.isCustom != null ?  r2.author.avatar.isCustom: r1.author.avatar.isCustom;
        }

        r1.author.avatar.permalink = r1.author.avatar.permalink .equals(r2.author.avatar.permalink)    ?    r1.author.avatar.permalink  :  r2.author.avatar.permalink;

        //Compare Small
        r1.author.avatar.small.cache         = r1.author.avatar.small.cache         .equals(r2.author.avatar.small.cache        )    ?    r1.author.avatar.small.cache          :  r2.author.avatar.small.cache        ;
        r1.author.avatar.small.permalink     = r1.author.avatar.small.permalink     .equals(r2.author.avatar.small.permalink    )    ?    r1.author.avatar.small.permalink      :  r2.author.avatar.small.permalink    ;

        //Compare Large
        r1.author.avatar.large.cache         = r1.author.avatar.large.cache         .equals(r2.author.avatar.large.cache        )    ?    r1.author.avatar.large.cache          :  r2.author.avatar.large.cache        ;
        r1.author.avatar.large.permalink     = r1.author.avatar.large.permalink     .equals(r2.author.avatar.large.permalink    )    ?    r1.author.avatar.large.permalink      :  r2.author.avatar.large.permalink    ;
    }

    public static List<Response> mergeAllJsonFiles(List<Response> base, List<List<Response>> jsonObjects){
        List<Response> mergedJson = base;
        for(int i = 0; i < jsonObjects.size(); i ++){
            mergeJsonIntoBase(mergedJson, jsonObjects.get(i));
        }

        return mergedJson;
    }



    public static void main(String[] args) throws FileNotFoundException {
        List<String> jsonStrings = filesToListOfStrings(fileNames);
        Collections.sort(jsonStrings);
        List<List<Response>> jsonObjects = stringListToJSONList(jsonStrings);

        List<Response> base = jsonObjects.get(0);


        List<Response> mergedJson = mergeAllJsonFiles(base, jsonObjects);

        //Create GSONBuilder which will organize data in an understandable format
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //mergedJson object back to JSON and to a newly merged file
        try {
            FileWriter fw = new FileWriter("./test.json");
            gson.toJson(mergedJson, fw);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
