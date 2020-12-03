package com.example.mybooklist;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class QueryUtils {

    /** Sample JSON response for a USGS query */
    private static final String SAMPLE_JSON_RESPONSE = "{\n" +
            "  \"kind\": \"books#volumes\",\n" +
            "  \"totalItems\": 1991,\n" +
            "  \"items\": [\n" +
            "    {\n" +
            "      \"kind\": \"books#volume\",\n" +
            "      \"id\": \"qKFDDAAAQBAJ\",\n" +
            "      \"etag\": \"M7gycqL48/E\",\n" +
            "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/qKFDDAAAQBAJ\",\n" +
            "      \"volumeInfo\": {\n" +
            "        \"title\": \"Android\",\n" +
            "        \"authors\": [\n" +
            "          \"P.K. Dixit\"\n" +
            "        ],\n" +
            "        \"publisher\": \"Vikas Publishing House\",\n" +
            "        \"publishedDate\": \"2014\",\n" +
            "        \"description\": \"Android is a movement that has transferred data from laptop to hand-held devices like mobiles. Though there are alternate technologies that compete with Android, but it is the front runner in mobile technology by a long distance. Good knowledge in basic Java will help you to understand and develop Android technology and apps. Many universities in India and across the world are now teaching Android in their syllabus, which shows the importance of this subject. This book can be read by anyone who knows Java and XML concepts. It includes a lot of diagrams along with explanations to facilitate better understanding by students. This book aptly concludes with a project that uses Android, which will greatly benefit students in learning the practical aspects of Android. Key Features • Instructions in designing different Android user interfaces • Thorough explanations of all activities • JSON • Android-based project to aid practical understanding\",\n" +
            "        \"industryIdentifiers\": [\n" +
            "          {\n" +
            "            \"type\": \"ISBN_13\",\n" +
            "            \"identifier\": \"9789325977884\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"ISBN_10\",\n" +
            "            \"identifier\": \"9325977885\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"readingModes\": {\n" +
            "          \"text\": false,\n" +
            "          \"image\": true\n" +
            "        },\n" +
            "        \"pageCount\": 372,\n" +
            "        \"printType\": \"BOOK\",\n" +
            "        \"categories\": [\n" +
            "          \"Computers\"\n" +
            "        ],\n" +
            "        \"averageRating\": 3,\n" +
            "        \"ratingsCount\": 1,\n" +
            "        \"maturityRating\": \"NOT_MATURE\",\n" +
            "        \"allowAnonLogging\": true,\n" +
            "        \"contentVersion\": \"preview-1.0.0\",\n" +
            "        \"panelizationSummary\": {\n" +
            "          \"containsEpubBubbles\": false,\n" +
            "          \"containsImageBubbles\": false\n" +
            "        },\n" +
            "        \"imageLinks\": {\n" +
            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=qKFDDAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "          \"thumbnail\": \"http://books.google.com/books/content?id=qKFDDAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "        },\n" +
            "        \"language\": \"en\",\n" +
            "        \"previewLink\": \"http://books.google.co.in/books?id=qKFDDAAAQBAJ&printsec=frontcover&dq=android&hl=&cd=1&source=gbs_api\",\n" +
            "        \"infoLink\": \"https://play.google.com/store/books/details?id=qKFDDAAAQBAJ&source=gbs_api\",\n" +
            "        \"canonicalVolumeLink\": \"https://play.google.com/store/books/details?id=qKFDDAAAQBAJ\"\n" +
            "      },\n" +
            "      \"saleInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"saleability\": \"FOR_SALE\",\n" +
            "        \"isEbook\": true,\n" +
            "        \"listPrice\": {\n" +
            "          \"amount\": 442.5,\n" +
            "          \"currencyCode\": \"INR\"\n" +
            "        },\n" +
            "        \"retailPrice\": {\n" +
            "          \"amount\": 318.25,\n" +
            "          \"currencyCode\": \"INR\"\n" +
            "        },\n" +
            "        \"buyLink\": \"https://play.google.com/store/books/details?id=qKFDDAAAQBAJ&rdid=book-qKFDDAAAQBAJ&rdot=1&source=gbs_api\",\n" +
            "        \"offers\": [\n" +
            "          {\n" +
            "            \"finskyOfferType\": 1,\n" +
            "            \"listPrice\": {\n" +
            "              \"amountInMicros\": 442500000,\n" +
            "              \"currencyCode\": \"INR\"\n" +
            "            },\n" +
            "            \"retailPrice\": {\n" +
            "              \"amountInMicros\": 318250000,\n" +
            "              \"currencyCode\": \"INR\"\n" +
            "            }\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"accessInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"viewability\": \"PARTIAL\",\n" +
            "        \"embeddable\": true,\n" +
            "        \"publicDomain\": false,\n" +
            "        \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "        \"epub\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"pdf\": {\n" +
            "          \"isAvailable\": true,\n" +
            "          \"acsTokenLink\": \"http://books.google.co.in/books/download/Android-sample-pdf.acsm?id=qKFDDAAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "        },\n" +
            "        \"webReaderLink\": \"http://play.google.com/books/reader?id=qKFDDAAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "        \"accessViewStatus\": \"SAMPLE\",\n" +
            "        \"quoteSharingAllowed\": false\n" +
            "      },\n" +
            "      \"searchInfo\": {\n" +
            "        \"textSnippet\": \"Many universities in India and across the world are now teaching Android in their syllabus, which shows the importance of this subject. This book can be read by anyone who knows Java and XML concepts.\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"books#volume\",\n" +
            "      \"id\": \"BvhGDwAAQBAJ\",\n" +
            "      \"etag\": \"GM7quhinF+c\",\n" +
            "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/BvhGDwAAQBAJ\",\n" +
            "      \"volumeInfo\": {\n" +
            "        \"title\": \"Android Studio\",\n" +
            "        \"subtitle\": \"Apps Development\",\n" +
            "        \"authors\": [\n" +
            "          \"AMC College \"\n" +
            "        ],\n" +
            "        \"publisher\": \"Advanced Micro Systems Sdn Bhd\",\n" +
            "        \"description\": \"This manual will covers Introduction To Android Studio,Understanding Layout Using Xml Visualizer, Setting Up An Android Studio Development Environment, Navigating Android Studio, Making Your First App: Hello World and Run The App On Your Phone\",\n" +
            "        \"readingModes\": {\n" +
            "          \"text\": false,\n" +
            "          \"image\": true\n" +
            "        },\n" +
            "        \"printType\": \"BOOK\",\n" +
            "        \"maturityRating\": \"NOT_MATURE\",\n" +
            "        \"allowAnonLogging\": true,\n" +
            "        \"contentVersion\": \"0.3.2.0.preview.1\",\n" +
            "        \"panelizationSummary\": {\n" +
            "          \"containsEpubBubbles\": false,\n" +
            "          \"containsImageBubbles\": false\n" +
            "        },\n" +
            "        \"imageLinks\": {\n" +
            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=BvhGDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "          \"thumbnail\": \"http://books.google.com/books/content?id=BvhGDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "        },\n" +
            "        \"language\": \"en\",\n" +
            "        \"previewLink\": \"http://books.google.co.in/books?id=BvhGDwAAQBAJ&printsec=frontcover&dq=android&hl=&cd=2&source=gbs_api\",\n" +
            "        \"infoLink\": \"https://play.google.com/store/books/details?id=BvhGDwAAQBAJ&source=gbs_api\",\n" +
            "        \"canonicalVolumeLink\": \"https://play.google.com/store/books/details?id=BvhGDwAAQBAJ\"\n" +
            "      },\n" +
            "      \"saleInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"saleability\": \"FOR_SALE\",\n" +
            "        \"isEbook\": true,\n" +
            "        \"listPrice\": {\n" +
            "          \"amount\": 259.03,\n" +
            "          \"currencyCode\": \"INR\"\n" +
            "        },\n" +
            "        \"retailPrice\": {\n" +
            "          \"amount\": 181.32,\n" +
            "          \"currencyCode\": \"INR\"\n" +
            "        },\n" +
            "        \"buyLink\": \"https://play.google.com/store/books/details?id=BvhGDwAAQBAJ&rdid=book-BvhGDwAAQBAJ&rdot=1&source=gbs_api\",\n" +
            "        \"offers\": [\n" +
            "          {\n" +
            "            \"finskyOfferType\": 1,\n" +
            "            \"listPrice\": {\n" +
            "              \"amountInMicros\": 259030000,\n" +
            "              \"currencyCode\": \"INR\"\n" +
            "            },\n" +
            "            \"retailPrice\": {\n" +
            "              \"amountInMicros\": 181320000,\n" +
            "              \"currencyCode\": \"INR\"\n" +
            "            }\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"accessInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"viewability\": \"PARTIAL\",\n" +
            "        \"embeddable\": true,\n" +
            "        \"publicDomain\": false,\n" +
            "        \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "        \"epub\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"pdf\": {\n" +
            "          \"isAvailable\": true,\n" +
            "          \"acsTokenLink\": \"http://books.google.co.in/books/download/Android_Studio-sample-pdf.acsm?id=BvhGDwAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "        },\n" +
            "        \"webReaderLink\": \"http://play.google.com/books/reader?id=BvhGDwAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "        \"accessViewStatus\": \"SAMPLE\",\n" +
            "        \"quoteSharingAllowed\": false\n" +
            "      },\n" +
            "      \"searchInfo\": {\n" +
            "        \"textSnippet\": \"This manual will covers Introduction To Android Studio,Understanding Layout Using Xml Visualizer, Setting Up An Android Studio Development Environment, Navigating Android Studio, Making Your First App: Hello World and Run The App On Your ...\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"books#volume\",\n" +
            "      \"id\": \"3Wi2gwGoZZ0C\",\n" +
            "      \"etag\": \"GxRAjNleUJI\",\n" +
            "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/3Wi2gwGoZZ0C\",\n" +
            "      \"volumeInfo\": {\n" +
            "        \"title\": \"The Android Developer's Collection (Collection)\",\n" +
            "        \"authors\": [\n" +
            "          \"James Steele\",\n" +
            "          \"Nelson To\",\n" +
            "          \"Shane Conder\"\n" +
            "        ],\n" +
            "        \"publisher\": \"Addison-Wesley Professional\",\n" +
            "        \"publishedDate\": \"2011-12-09\",\n" +
            "        \"description\": \"The Android Developer's Collection includes two highly successful Android application development eBooks: \\\" The Android Developer's Cookbook: Building Applications with the Android SDK \\\" \\\"Android Wireless Application Development,\\\" Second Edition This collection is an indispensable resource for every member of the Android development team: software developers with all levels of mobile experience, team leaders and project managers, testers and QA specialists, software architects, and even marketers. Completely up-to-date to reflect the newest and most widely used Android SDKs, \\\"The Android Developer's Cookbook \\\"is the essential resource for developers building apps for any Android device, from phones to tablets. Proven, modular recipes take you from the absolute basics to advanced location-based services, security techniques, and performance optimization. You'll learn how to write apps from scratch, ensure interoperability, choose the best solutions for common problems, and avoid development pitfalls. \\\"Android Wireless Application Development, \\\" Second Edition, delivers all the up-to-date information, tested code, and best practices you need to create and market successful mobile apps with the latest versions of Android. Drawing on their extensive experience with mobile and wireless development, Lauren Darcey and Shane Conder cover every step: concept, design, coding, testing, packaging, and delivery. Every chapter of this edition has been updated for the newest Android SDKs, tools, utilities, and hardware. All sample code has been overhauled and tested on leading devices from multiple companies, including HTC, Motorola, and ARCHOS. Many new examples have been added, including complete new applications. In this collection, coverage includes Implementing threads, services, receivers, and other background tasks Providing user alerts Organizing user interface layouts and views Managing user-initiated events such as touches and gestures Recording and playing audio and video Using hardware APIs available on Android devices Interacting with other devices via SMS, Web browsing, and social networking Storing data efficiently with SQLite and its alternatives Accessing location data via GPS Using location-related services such as the Google Maps API Building faster applications with native code Providing backup and restore with the Android Backup Manager Testing and debugging apps throughout the development cycle Using Web APIs, using the Android NDK, extending application reach, managing users, synchronizing data, managing backups, and handling advanced user input Editing Android manifest files, registering content providers, and designing and testing apps Working with Bluetooth, voice recognition, App Widgets, live folders, live wallpapers, and global search Programming 3D graphics with OpenGL ES 2.0\",\n" +
            "        \"industryIdentifiers\": [\n" +
            "          {\n" +
            "            \"type\": \"ISBN_13\",\n" +
            "            \"identifier\": \"9780132928618\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"ISBN_10\",\n" +
            "            \"identifier\": \"0132928612\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"readingModes\": {\n" +
            "          \"text\": false,\n" +
            "          \"image\": true\n" +
            "        },\n" +
            "        \"pageCount\": 1156,\n" +
            "        \"printType\": \"BOOK\",\n" +
            "        \"maturityRating\": \"NOT_MATURE\",\n" +
            "        \"allowAnonLogging\": false,\n" +
            "        \"contentVersion\": \"preview-1.0.0\",\n" +
            "        \"imageLinks\": {\n" +
            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=3Wi2gwGoZZ0C&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "          \"thumbnail\": \"http://books.google.com/books/content?id=3Wi2gwGoZZ0C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "        },\n" +
            "        \"language\": \"en\",\n" +
            "        \"previewLink\": \"http://books.google.co.in/books?id=3Wi2gwGoZZ0C&printsec=frontcover&dq=android&hl=&cd=3&source=gbs_api\",\n" +
            "        \"infoLink\": \"http://books.google.co.in/books?id=3Wi2gwGoZZ0C&dq=android&hl=&source=gbs_api\",\n" +
            "        \"canonicalVolumeLink\": \"https://books.google.com/books/about/The_Android_Developer_s_Collection_Colle.html?hl=&id=3Wi2gwGoZZ0C\"\n" +
            "      },\n" +
            "      \"saleInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"saleability\": \"NOT_FOR_SALE\",\n" +
            "        \"isEbook\": false\n" +
            "      },\n" +
            "      \"accessInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"viewability\": \"PARTIAL\",\n" +
            "        \"embeddable\": true,\n" +
            "        \"publicDomain\": false,\n" +
            "        \"textToSpeechPermission\": \"ALLOWED_FOR_ACCESSIBILITY\",\n" +
            "        \"epub\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"pdf\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"webReaderLink\": \"http://play.google.com/books/reader?id=3Wi2gwGoZZ0C&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "        \"accessViewStatus\": \"SAMPLE\",\n" +
            "        \"quoteSharingAllowed\": false\n" +
            "      },\n" +
            "      \"searchInfo\": {\n" +
            "        \"textSnippet\": \"The Android Developer&#39;s Collection includes two highly successful Android application development eBooks: &quot; The Android Developer&#39;s Cookbook: Building Applications with the Android SDK &quot; &quot;Android Wireless Application Development,&quot; Second ...\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"books#volume\",\n" +
            "      \"id\": \"_1otcB06lWYC\",\n" +
            "      \"etag\": \"xnjaDNR/OP8\",\n" +
            "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/_1otcB06lWYC\",\n" +
            "      \"volumeInfo\": {\n" +
            "        \"title\": \"Beginning Android 4 Application Development\",\n" +
            "        \"authors\": [\n" +
            "          \"Wei-Meng Lee\"\n" +
            "        ],\n" +
            "        \"publisher\": \"John Wiley & Sons\",\n" +
            "        \"publishedDate\": \"2012-02-03\",\n" +
            "        \"description\": \"Understand Android OS for both smartphone and tablet programming This fast-paced introduction to the newest release of Android OS gives aspiring mobile app developers what they need to know to program for today's hottest Android smartphones and tablets. Android 4 OS is, for the first time, a single solution for both smartphones and tablets, so if you master the information in this helpful guide, you'll be well on your way to successful development for both devices. From using activities and intents and creating rich user interfaces to working with SMS, messaging APIs, and the Android SDK, what you need is here. Provides clear instructions backed by real-world programming examples Begins with the basics and covers everything Android 4 developers need to know for both smartphones and tablets Explains how to customize activities and intents, create rich user interfaces, and manage data Helps you work with SMS and messaging APIs, the Android SDK, and using location-based services Details how to package and publish your applications to the Android Market Beginning Android 4 Application Development pares down the most essential steps you need to know so you can start creating Android applications today.\",\n" +
            "        \"industryIdentifiers\": [\n" +
            "          {\n" +
            "            \"type\": \"ISBN_13\",\n" +
            "            \"identifier\": \"9781118240670\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"ISBN_10\",\n" +
            "            \"identifier\": \"1118240677\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"readingModes\": {\n" +
            "          \"text\": true,\n" +
            "          \"image\": true\n" +
            "        },\n" +
            "        \"pageCount\": 560,\n" +
            "        \"printType\": \"BOOK\",\n" +
            "        \"categories\": [\n" +
            "          \"Computers\"\n" +
            "        ],\n" +
            "        \"averageRating\": 3.5,\n" +
            "        \"ratingsCount\": 7,\n" +
            "        \"maturityRating\": \"NOT_MATURE\",\n" +
            "        \"allowAnonLogging\": true,\n" +
            "        \"contentVersion\": \"1.9.8.0.preview.3\",\n" +
            "        \"panelizationSummary\": {\n" +
            "          \"containsEpubBubbles\": false,\n" +
            "          \"containsImageBubbles\": false\n" +
            "        },\n" +
            "        \"imageLinks\": {\n" +
            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=_1otcB06lWYC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "          \"thumbnail\": \"http://books.google.com/books/content?id=_1otcB06lWYC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "        },\n" +
            "        \"language\": \"en\",\n" +
            "        \"previewLink\": \"http://books.google.co.in/books?id=_1otcB06lWYC&printsec=frontcover&dq=android&hl=&cd=4&source=gbs_api\",\n" +
            "        \"infoLink\": \"https://play.google.com/store/books/details?id=_1otcB06lWYC&source=gbs_api\",\n" +
            "        \"canonicalVolumeLink\": \"https://play.google.com/store/books/details?id=_1otcB06lWYC\"\n" +
            "      },\n" +
            "      \"saleInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"saleability\": \"FOR_SALE\",\n" +
            "        \"isEbook\": true,\n" +
            "        \"listPrice\": {\n" +
            "          \"amount\": 742.22,\n" +
            "          \"currencyCode\": \"INR\"\n" +
            "        },\n" +
            "        \"retailPrice\": {\n" +
            "          \"amount\": 371.11,\n" +
            "          \"currencyCode\": \"INR\"\n" +
            "        },\n" +
            "        \"buyLink\": \"https://play.google.com/store/books/details?id=_1otcB06lWYC&rdid=book-_1otcB06lWYC&rdot=1&source=gbs_api\",\n" +
            "        \"offers\": [\n" +
            "          {\n" +
            "            \"finskyOfferType\": 1,\n" +
            "            \"listPrice\": {\n" +
            "              \"amountInMicros\": 742220000,\n" +
            "              \"currencyCode\": \"INR\"\n" +
            "            },\n" +
            "            \"retailPrice\": {\n" +
            "              \"amountInMicros\": 371110000,\n" +
            "              \"currencyCode\": \"INR\"\n" +
            "            }\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"accessInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"viewability\": \"PARTIAL\",\n" +
            "        \"embeddable\": true,\n" +
            "        \"publicDomain\": false,\n" +
            "        \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "        \"epub\": {\n" +
            "          \"isAvailable\": true,\n" +
            "          \"acsTokenLink\": \"http://books.google.co.in/books/download/Beginning_Android_4_Application_Developm-sample-epub.acsm?id=_1otcB06lWYC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "        },\n" +
            "        \"pdf\": {\n" +
            "          \"isAvailable\": true,\n" +
            "          \"acsTokenLink\": \"http://books.google.co.in/books/download/Beginning_Android_4_Application_Developm-sample-pdf.acsm?id=_1otcB06lWYC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "        },\n" +
            "        \"webReaderLink\": \"http://play.google.com/books/reader?id=_1otcB06lWYC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "        \"accessViewStatus\": \"SAMPLE\",\n" +
            "        \"quoteSharingAllowed\": false\n" +
            "      },\n" +
            "      \"searchInfo\": {\n" +
            "        \"textSnippet\": \"Beginning Android 4 Application Development: Explains how to adapt to display orientation, understand the components of a screen, and handle user interface notifications Explains the various elements that go into designing your user ...\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"books#volume\",\n" +
            "      \"id\": \"bYElAgAAQBAJ\",\n" +
            "      \"etag\": \"hZM+8OWsuRE\",\n" +
            "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/bYElAgAAQBAJ\",\n" +
            "      \"volumeInfo\": {\n" +
            "        \"title\": \"Introduction to Android Application Development\",\n" +
            "        \"subtitle\": \"Android Essentials\",\n" +
            "        \"authors\": [\n" +
            "          \"Joseph Annuzzi Jr.\",\n" +
            "          \"Lauren Darcey\",\n" +
            "          \"Shane Conder\"\n" +
            "        ],\n" +
            "        \"publisher\": \"Addison-Wesley\",\n" +
            "        \"publishedDate\": \"2013-11-21\",\n" +
            "        \"description\": \"Bonus KitKat material is available for download at www.informit.com/title/9780321940261 What Every Android™ App Developer Should Know Today: Android Tools, App/UI Design, Testing, Publishing, And More This fully reworked edition of a proven title is the most useful real-world guide to building robust, commercial-grade Android™ apps. The content is revised and updated for the latest Android 4.3 SDK and the newest development best practices. Introduction to Android™ Application Development: Android Essentials, Fourth Edition, covers all you need to quickly start developing professional apps for today’s Android devices. Three expert developers guide you through setting up your development environment, designing user interfaces, developing for diverse devices, and optimizing your entire app-development process–from design through publication. Updated throughout, this title includes extensive coverage of the most useful new Android tools and utilities. It adds an all-new chapter on planning an amazing Android app user experience, plus extensive new coverage of unit testing, dialogs, preferences, and app publishing. Throughout, key concepts are taught through clear, up-to-date example code. This edition offers Fully updated introductions to the latest Android 4.3 APIs, tools, utilities, and best practices Up-to-date strategies for leveraging new Android capabilities while preserving compatibility Navigation patterns and code samples for delivering more intuitive user experiences Example-based explanations of ActionBars, DialogFragments, and other key concepts Expert automated testing techniques to quickly improve code quality New Google Play Developer Console app publishing techniques that also offer more control For Android developers at all levels of experience, this reference is now more valuable than ever. Students, instructors, and self-learners will especially appreciate new chapter-ending questions and exercises, carefully designed to test knowledge and deepen mastery. Annuzzi has released new source code samples for use with Android Studio. The code updates are posted to the associated blog site: http://introductiontoandroid.blogspot.com/ Note: This revamped, newly titled edition is a complete update of Android™ Wireless Application Development, Volume I: Android Essentials, Third Edition\",\n" +
            "        \"industryIdentifiers\": [\n" +
            "          {\n" +
            "            \"type\": \"ISBN_13\",\n" +
            "            \"identifier\": \"9780133477337\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"ISBN_10\",\n" +
            "            \"identifier\": \"0133477339\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"readingModes\": {\n" +
            "          \"text\": true,\n" +
            "          \"image\": true\n" +
            "        },\n" +
            "        \"pageCount\": 672,\n" +
            "        \"printType\": \"BOOK\",\n" +
            "        \"categories\": [\n" +
            "          \"Computers\"\n" +
            "        ],\n" +
            "        \"maturityRating\": \"NOT_MATURE\",\n" +
            "        \"allowAnonLogging\": true,\n" +
            "        \"contentVersion\": \"1.4.4.0.preview.3\",\n" +
            "        \"panelizationSummary\": {\n" +
            "          \"containsEpubBubbles\": false,\n" +
            "          \"containsImageBubbles\": false\n" +
            "        },\n" +
            "        \"imageLinks\": {\n" +
            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=bYElAgAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "          \"thumbnail\": \"http://books.google.com/books/content?id=bYElAgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "        },\n" +
            "        \"language\": \"en\",\n" +
            "        \"previewLink\": \"http://books.google.co.in/books?id=bYElAgAAQBAJ&printsec=frontcover&dq=android&hl=&cd=5&source=gbs_api\",\n" +
            "        \"infoLink\": \"https://play.google.com/store/books/details?id=bYElAgAAQBAJ&source=gbs_api\",\n" +
            "        \"canonicalVolumeLink\": \"https://play.google.com/store/books/details?id=bYElAgAAQBAJ\"\n" +
            "      },\n" +
            "      \"saleInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"saleability\": \"FOR_SALE\",\n" +
            "        \"isEbook\": true,\n" +
            "        \"listPrice\": {\n" +
            "          \"amount\": 1735.23,\n" +
            "          \"currencyCode\": \"INR\"\n" +
            "        },\n" +
            "        \"retailPrice\": {\n" +
            "          \"amount\": 1735.23,\n" +
            "          \"currencyCode\": \"INR\"\n" +
            "        },\n" +
            "        \"buyLink\": \"https://play.google.com/store/books/details?id=bYElAgAAQBAJ&rdid=book-bYElAgAAQBAJ&rdot=1&source=gbs_api\",\n" +
            "        \"offers\": [\n" +
            "          {\n" +
            "            \"finskyOfferType\": 1,\n" +
            "            \"listPrice\": {\n" +
            "              \"amountInMicros\": 1735230000,\n" +
            "              \"currencyCode\": \"INR\"\n" +
            "            },\n" +
            "            \"retailPrice\": {\n" +
            "              \"amountInMicros\": 1735230000,\n" +
            "              \"currencyCode\": \"INR\"\n" +
            "            }\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"accessInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"viewability\": \"PARTIAL\",\n" +
            "        \"embeddable\": true,\n" +
            "        \"publicDomain\": false,\n" +
            "        \"textToSpeechPermission\": \"ALLOWED_FOR_ACCESSIBILITY\",\n" +
            "        \"epub\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"pdf\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"webReaderLink\": \"http://play.google.com/books/reader?id=bYElAgAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "        \"accessViewStatus\": \"SAMPLE\",\n" +
            "        \"quoteSharingAllowed\": false\n" +
            "      },\n" +
            "      \"searchInfo\": {\n" +
            "        \"textSnippet\": \"This edition offers Fully updated introductions to the latest Android 4.3 APIs, tools, utilities, and best practices Up-to-date strategies for leveraging new Android capabilities while preserving compatibility Navigation patterns and code ...\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"books#volume\",\n" +
            "      \"id\": \"w8TsMgEACAAJ\",\n" +
            "      \"etag\": \"lC5nElLfWoc\",\n" +
            "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/w8TsMgEACAAJ\",\n" +
            "      \"volumeInfo\": {\n" +
            "        \"title\": \"Android (Operating System) - Unabridged Guide\",\n" +
            "        \"authors\": [\n" +
            "          \"Aaron Bryan\"\n" +
            "        ],\n" +
            "        \"publisher\": \"Tebbo\",\n" +
            "        \"publishedDate\": \"2012-09\",\n" +
            "        \"description\": \"Complete, Unabridged Guide to Android (operating system). Get the information you need--fast! This comprehensive guide offers a thorough view of key knowledge and detailed insight. It's all you need. Here's part of the content - you would like to know it all? Delve into this book today!..... : Developers write primarily in a customized version of Java, and apps can be downloaded from online stores such as Google Play (formerly Android Market), the app store run by Google, or third-party sites. ... Android consists of a kernel based on the Linux kernel 2. 6 and Linux Kernel 3. x (Android 4. 0 onwards), with middleware, libraries and APIs written in C and application software running on an application framework which includes Java-compatible libraries based on Apache Harmony. ... In early 2011, Google chose to temporarily withhold the Android source code to the tablet-only Honeycomb release, the reason, according to Andy Rubin in an official Android blog post, was because Honeycomb was rushed for production of the Motorola Xoom, and they did not want third parties creating a really bad user experience by attempting to put onto smartphones a version of Android intended for tablets. ...However, as community-developed software has grown more popular, and following a statement by the Librarian of Congress in the United States that permits the jailbreaking of mobile devices, manufacturers and carriers have softened their position regarding third party development, with some, including HTC, Motorola, Samsung and Sony Ericsson, providing support and encouraging development. There is absolutely nothing that isn't thoroughly covered in the book. It is straightforward, and does an excellent job of explaining all about Android (operating system) in key topics and material. There is no reason to invest in any other materials to learn about Android (operating system). You'll understand it all. Inside the Guide: Android (operating system), Google Currents, Google Contacts, Google Code, Google Chrome OS, Google Chrome, Google China, Google Calendar, Google Buzz, Google Authenticator, Google+, Google, Gmail, Galaxy Nexus, GNU/Linux naming controversy, Firefox OS, Fastboot, Embedded Linux, Eclipse (software), Dalvik (software), CyanogenMod, Comparison of smartphones, Comparison of netbook-oriented Linux distributions, Comparison of Java and Android API, Comparison of Android e-book reader software, Comparison of Android devices, Carrier IQ, BlackBerry Tablet OS, BlackBerry OS, Baidu Yi, Avast!, Application software, Application programming interface, Apple Inc. v. Samsung Electronics Co., Ltd., Apache Harmony, Andy Rubin, Androidland, Android version history, Android software development, Android lawn statues, Android Developer Lab, Android Developer Challenge, Android Debug Bridge, Amazon Appstore, AdMob, AVG Technologies, ARM architecture, APK (file format), 3G\",\n" +
            "        \"industryIdentifiers\": [\n" +
            "          {\n" +
            "            \"type\": \"ISBN_10\",\n" +
            "            \"identifier\": \"1486198511\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"ISBN_13\",\n" +
            "            \"identifier\": \"9781486198511\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"readingModes\": {\n" +
            "          \"text\": false,\n" +
            "          \"image\": false\n" +
            "        },\n" +
            "        \"pageCount\": 330,\n" +
            "        \"printType\": \"BOOK\",\n" +
            "        \"categories\": [\n" +
            "          \"Reference\"\n" +
            "        ],\n" +
            "        \"maturityRating\": \"NOT_MATURE\",\n" +
            "        \"allowAnonLogging\": false,\n" +
            "        \"contentVersion\": \"preview-1.0.0\",\n" +
            "        \"imageLinks\": {\n" +
            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=w8TsMgEACAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api\",\n" +
            "          \"thumbnail\": \"http://books.google.com/books/content?id=w8TsMgEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api\"\n" +
            "        },\n" +
            "        \"language\": \"en\",\n" +
            "        \"previewLink\": \"http://books.google.co.in/books?id=w8TsMgEACAAJ&dq=android&hl=&cd=6&source=gbs_api\",\n" +
            "        \"infoLink\": \"http://books.google.co.in/books?id=w8TsMgEACAAJ&dq=android&hl=&source=gbs_api\",\n" +
            "        \"canonicalVolumeLink\": \"https://books.google.com/books/about/Android_Operating_System_Unabridged_Guid.html?hl=&id=w8TsMgEACAAJ\"\n" +
            "      },\n" +
            "      \"saleInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"saleability\": \"NOT_FOR_SALE\",\n" +
            "        \"isEbook\": false\n" +
            "      },\n" +
            "      \"accessInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"viewability\": \"NO_PAGES\",\n" +
            "        \"embeddable\": false,\n" +
            "        \"publicDomain\": false,\n" +
            "        \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "        \"epub\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"pdf\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"webReaderLink\": \"http://play.google.com/books/reader?id=w8TsMgEACAAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "        \"accessViewStatus\": \"NONE\",\n" +
            "        \"quoteSharingAllowed\": false\n" +
            "      },\n" +
            "      \"searchInfo\": {\n" +
            "        \"textSnippet\": \"Get the information you need--fast! This comprehensive guide offers a thorough view of key knowledge and detailed insight. It&#39;s all you need. Here&#39;s part of the content - you would like to know it all? Delve into this book today!\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"books#volume\",\n" +
            "      \"id\": \"5BGBswAQSiEC\",\n" +
            "      \"etag\": \"a4zQnZ2fRU0\",\n" +
            "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/5BGBswAQSiEC\",\n" +
            "      \"volumeInfo\": {\n" +
            "        \"title\": \"Programming Android\",\n" +
            "        \"authors\": [\n" +
            "          \"Zigurd Mednieks\",\n" +
            "          \"Laird Dornin\",\n" +
            "          \"Blake Meike\",\n" +
            "          \"Masumi Nakamura\"\n" +
            "        ],\n" +
            "        \"publisher\": \"\\\"O'Reilly Media, Inc.\\\"\",\n" +
            "        \"publishedDate\": \"2011-07-22\",\n" +
            "        \"description\": \"Presents instructions for creating Android applications for mobile devices using Java.\",\n" +
            "        \"industryIdentifiers\": [\n" +
            "          {\n" +
            "            \"type\": \"ISBN_13\",\n" +
            "            \"identifier\": \"9781449389697\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"ISBN_10\",\n" +
            "            \"identifier\": \"1449389694\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"readingModes\": {\n" +
            "          \"text\": false,\n" +
            "          \"image\": true\n" +
            "        },\n" +
            "        \"pageCount\": 482,\n" +
            "        \"printType\": \"BOOK\",\n" +
            "        \"categories\": [\n" +
            "          \"Computers\"\n" +
            "        ],\n" +
            "        \"averageRating\": 3.5,\n" +
            "        \"ratingsCount\": 2,\n" +
            "        \"maturityRating\": \"NOT_MATURE\",\n" +
            "        \"allowAnonLogging\": true,\n" +
            "        \"contentVersion\": \"0.3.0.0.preview.1\",\n" +
            "        \"imageLinks\": {\n" +
            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=5BGBswAQSiEC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "          \"thumbnail\": \"http://books.google.com/books/content?id=5BGBswAQSiEC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "        },\n" +
            "        \"language\": \"en\",\n" +
            "        \"previewLink\": \"http://books.google.co.in/books?id=5BGBswAQSiEC&pg=PA431&dq=android&hl=&cd=7&source=gbs_api\",\n" +
            "        \"infoLink\": \"http://books.google.co.in/books?id=5BGBswAQSiEC&dq=android&hl=&source=gbs_api\",\n" +
            "        \"canonicalVolumeLink\": \"https://books.google.com/books/about/Programming_Android.html?hl=&id=5BGBswAQSiEC\"\n" +
            "      },\n" +
            "      \"saleInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"saleability\": \"NOT_FOR_SALE\",\n" +
            "        \"isEbook\": false\n" +
            "      },\n" +
            "      \"accessInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"viewability\": \"PARTIAL\",\n" +
            "        \"embeddable\": true,\n" +
            "        \"publicDomain\": false,\n" +
            "        \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "        \"epub\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"pdf\": {\n" +
            "          \"isAvailable\": true\n" +
            "        },\n" +
            "        \"webReaderLink\": \"http://play.google.com/books/reader?id=5BGBswAQSiEC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "        \"accessViewStatus\": \"SAMPLE\",\n" +
            "        \"quoteSharingAllowed\": false\n" +
            "      },\n" +
            "      \"searchInfo\": {\n" +
            "        \"textSnippet\": \"... that enables the necessary interactions for making and managing connections \\u003cbr\\u003e\\nand for using applications that communicate over Bluetooth. \\u003cb\\u003eAndroid\\u003c/b\\u003e uses the \\u003cbr\\u003e\\nBluez Bluetooth stack, which is the most commonly used Bluetooth stack for \\u003cbr\\u003e\\nLinux.\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"books#volume\",\n" +
            "      \"id\": \"m16ccm8jAFUC\",\n" +
            "      \"etag\": \"5qZxr7Y3DGg\",\n" +
            "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/m16ccm8jAFUC\",\n" +
            "      \"volumeInfo\": {\n" +
            "        \"title\": \"The Complete Android Guide\",\n" +
            "        \"authors\": [\n" +
            "          \"Kevin Purdy\"\n" +
            "        ],\n" +
            "        \"publisher\": \"3ones Inc\",\n" +
            "        \"publishedDate\": \"2011-04-01\",\n" +
            "        \"industryIdentifiers\": [\n" +
            "          {\n" +
            "            \"type\": \"ISBN_13\",\n" +
            "            \"identifier\": \"9780982592625\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"ISBN_10\",\n" +
            "            \"identifier\": \"0982592620\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"readingModes\": {\n" +
            "          \"text\": true,\n" +
            "          \"image\": false\n" +
            "        },\n" +
            "        \"printType\": \"BOOK\",\n" +
            "        \"categories\": [\n" +
            "          \"Computers\"\n" +
            "        ],\n" +
            "        \"maturityRating\": \"NOT_MATURE\",\n" +
            "        \"allowAnonLogging\": false,\n" +
            "        \"contentVersion\": \"0.0.2.0.preview.2\",\n" +
            "        \"imageLinks\": {\n" +
            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=m16ccm8jAFUC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "          \"thumbnail\": \"http://books.google.com/books/content?id=m16ccm8jAFUC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "        },\n" +
            "        \"language\": \"en\",\n" +
            "        \"previewLink\": \"http://books.google.co.in/books?id=m16ccm8jAFUC&pg=PA93&dq=android&hl=&cd=8&source=gbs_api\",\n" +
            "        \"infoLink\": \"http://books.google.co.in/books?id=m16ccm8jAFUC&dq=android&hl=&source=gbs_api\",\n" +
            "        \"canonicalVolumeLink\": \"https://books.google.com/books/about/The_Complete_Android_Guide.html?hl=&id=m16ccm8jAFUC\"\n" +
            "      },\n" +
            "      \"saleInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"saleability\": \"NOT_FOR_SALE\",\n" +
            "        \"isEbook\": false\n" +
            "      },\n" +
            "      \"accessInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"viewability\": \"PARTIAL\",\n" +
            "        \"embeddable\": true,\n" +
            "        \"publicDomain\": false,\n" +
            "        \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "        \"epub\": {\n" +
            "          \"isAvailable\": true\n" +
            "        },\n" +
            "        \"pdf\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"webReaderLink\": \"http://play.google.com/books/reader?id=m16ccm8jAFUC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "        \"accessViewStatus\": \"SAMPLE\",\n" +
            "        \"quoteSharingAllowed\": false\n" +
            "      },\n" +
            "      \"searchInfo\": {\n" +
            "        \"textSnippet\": \"Your \\u003cb\\u003eAndroid\\u003c/b\\u003e phone can do all kinds of neat things with its almost ubiquitous \\u003cbr\\u003e\\naccess to the web, and browsing the web is one of its core abilities. Here&#39;s how to \\u003cbr\\u003e\\nmake the most of your browser—the app labeled, helpfully, &quot;Browser.&quot;&nbsp;...\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"books#volume\",\n" +
            "      \"id\": \"4RCEGbMrZ7oC\",\n" +
            "      \"etag\": \"tfOwxjIQUfY\",\n" +
            "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/4RCEGbMrZ7oC\",\n" +
            "      \"volumeInfo\": {\n" +
            "        \"title\": \"Building Android Apps with HTML, CSS, and JavaScript\",\n" +
            "        \"authors\": [\n" +
            "          \"Jonathan Stark\",\n" +
            "          \"Paco Nathan\",\n" +
            "          \"John Papaconstantinou\",\n" +
            "          \"Paco Lagerstrom\",\n" +
            "          \"Paco Hope\"\n" +
            "        ],\n" +
            "        \"publisher\": \"\\\"O'Reilly Media, Inc.\\\"\",\n" +
            "        \"publishedDate\": \"2010-09-27\",\n" +
            "        \"description\": \"If you know HTML, CSS, and JavaScript, you already have the tools you need to develop Android applications. This hands-on book shows you how to use these open source web standards to design and build apps that can be adapted for any Android device -- without having to use Java. You'll learn how to create an Android-friendly web app on the platform of your choice, and then convert it to a native Android app with the free PhoneGap framework. Discover why device-agnostic mobile apps are the wave of the future, and start building apps that offer greater flexibility and a broader reach. Learn the basics for making a web page look great on the Android web browser Convert a website into a web application, complete with progress indicators and more Add animation with jQTouch to make your web app look and feel like a native Android app Take advantage of client-side data storage with apps that run even when the Android device is offline Use PhoneGap to hook into advanced Android features -- including the accelerometer, geolocation, and alerts Test and debug your app on the Web under load with real users, and then submit the finished product to the Android Market This book received valuable community input through O'Reilly's Open Feedback Publishing System (OFPS). Learn more at http://labs.oreilly.com/ofps.html.\",\n" +
            "        \"industryIdentifiers\": [\n" +
            "          {\n" +
            "            \"type\": \"ISBN_10\",\n" +
            "            \"identifier\": \"1449396933\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"ISBN_13\",\n" +
            "            \"identifier\": \"9781449396930\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"readingModes\": {\n" +
            "          \"text\": true,\n" +
            "          \"image\": true\n" +
            "        },\n" +
            "        \"pageCount\": 184,\n" +
            "        \"printType\": \"BOOK\",\n" +
            "        \"categories\": [\n" +
            "          \"Computers\"\n" +
            "        ],\n" +
            "        \"averageRating\": 2,\n" +
            "        \"ratingsCount\": 5,\n" +
            "        \"maturityRating\": \"NOT_MATURE\",\n" +
            "        \"allowAnonLogging\": true,\n" +
            "        \"contentVersion\": \"0.8.7.0.preview.3\",\n" +
            "        \"panelizationSummary\": {\n" +
            "          \"containsEpubBubbles\": false,\n" +
            "          \"containsImageBubbles\": false\n" +
            "        },\n" +
            "        \"imageLinks\": {\n" +
            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=4RCEGbMrZ7oC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "          \"thumbnail\": \"http://books.google.com/books/content?id=4RCEGbMrZ7oC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "        },\n" +
            "        \"language\": \"en\",\n" +
            "        \"previewLink\": \"http://books.google.co.in/books?id=4RCEGbMrZ7oC&pg=PA28&dq=android&hl=&cd=9&source=gbs_api\",\n" +
            "        \"infoLink\": \"http://books.google.co.in/books?id=4RCEGbMrZ7oC&dq=android&hl=&source=gbs_api\",\n" +
            "        \"canonicalVolumeLink\": \"https://books.google.com/books/about/Building_Android_Apps_with_HTML_CSS_and.html?hl=&id=4RCEGbMrZ7oC\"\n" +
            "      },\n" +
            "      \"saleInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"saleability\": \"NOT_FOR_SALE\",\n" +
            "        \"isEbook\": false\n" +
            "      },\n" +
            "      \"accessInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"viewability\": \"PARTIAL\",\n" +
            "        \"embeddable\": true,\n" +
            "        \"publicDomain\": false,\n" +
            "        \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "        \"epub\": {\n" +
            "          \"isAvailable\": true\n" +
            "        },\n" +
            "        \"pdf\": {\n" +
            "          \"isAvailable\": true\n" +
            "        },\n" +
            "        \"webReaderLink\": \"http://play.google.com/books/reader?id=4RCEGbMrZ7oC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "        \"accessViewStatus\": \"SAMPLE\",\n" +
            "        \"quoteSharingAllowed\": false\n" +
            "      },\n" +
            "      \"searchInfo\": {\n" +
            "        \"textSnippet\": \"Add these lines to the head section of your HTML document: &lt;script type=&quot;text/\\u003cbr\\u003e\\njavascript&quot; src=&quot;jquery.js&quot;&gt;&lt;/script&gt; &lt;script type=&quot;text/javascript&quot; src=&quot;\\u003cb\\u003eandroid\\u003c/b\\u003e.js&quot;&gt;\\u003cbr\\u003e\\n&lt;/script&gt; jQuery downloads, documentation, and tutorials are available at http:&nbsp;...\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"books#volume\",\n" +
            "      \"id\": \"1C3yNgqZnUkC\",\n" +
            "      \"etag\": \"tQjbWl3ZYS8\",\n" +
            "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/1C3yNgqZnUkC\",\n" +
            "      \"volumeInfo\": {\n" +
            "        \"title\": \"Android Application Development For Dummies\",\n" +
            "        \"authors\": [\n" +
            "          \"Donn Felker\"\n" +
            "        ],\n" +
            "        \"publisher\": \"John Wiley & Sons\",\n" +
            "        \"publishedDate\": \"2010-11-17\",\n" +
            "        \"industryIdentifiers\": [\n" +
            "          {\n" +
            "            \"type\": \"ISBN_10\",\n" +
            "            \"identifier\": \"1118005155\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"ISBN_13\",\n" +
            "            \"identifier\": \"9781118005156\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"readingModes\": {\n" +
            "          \"text\": true,\n" +
            "          \"image\": true\n" +
            "        },\n" +
            "        \"pageCount\": 360,\n" +
            "        \"printType\": \"BOOK\",\n" +
            "        \"categories\": [\n" +
            "          \"Computers\"\n" +
            "        ],\n" +
            "        \"averageRating\": 3,\n" +
            "        \"ratingsCount\": 39,\n" +
            "        \"maturityRating\": \"NOT_MATURE\",\n" +
            "        \"allowAnonLogging\": true,\n" +
            "        \"contentVersion\": \"0.1.3.0.preview.3\",\n" +
            "        \"imageLinks\": {\n" +
            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=1C3yNgqZnUkC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "          \"thumbnail\": \"http://books.google.com/books/content?id=1C3yNgqZnUkC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "        },\n" +
            "        \"language\": \"en\",\n" +
            "        \"previewLink\": \"http://books.google.co.in/books?id=1C3yNgqZnUkC&pg=PA22&dq=android&hl=&cd=10&source=gbs_api\",\n" +
            "        \"infoLink\": \"http://books.google.co.in/books?id=1C3yNgqZnUkC&dq=android&hl=&source=gbs_api\",\n" +
            "        \"canonicalVolumeLink\": \"https://books.google.com/books/about/Android_Application_Development_For_Dumm.html?hl=&id=1C3yNgqZnUkC\"\n" +
            "      },\n" +
            "      \"saleInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"saleability\": \"NOT_FOR_SALE\",\n" +
            "        \"isEbook\": false\n" +
            "      },\n" +
            "      \"accessInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"viewability\": \"PARTIAL\",\n" +
            "        \"embeddable\": true,\n" +
            "        \"publicDomain\": false,\n" +
            "        \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "        \"epub\": {\n" +
            "          \"isAvailable\": true,\n" +
            "          \"acsTokenLink\": \"http://books.google.co.in/books/download/Android_Application_Development_For_Dumm-sample-epub.acsm?id=1C3yNgqZnUkC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "        },\n" +
            "        \"pdf\": {\n" +
            "          \"isAvailable\": true,\n" +
            "          \"acsTokenLink\": \"http://books.google.co.in/books/download/Android_Application_Development_For_Dumm-sample-pdf.acsm?id=1C3yNgqZnUkC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "        },\n" +
            "        \"webReaderLink\": \"http://play.google.com/books/reader?id=1C3yNgqZnUkC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "        \"accessViewStatus\": \"SAMPLE\",\n" +
            "        \"quoteSharingAllowed\": false\n" +
            "      },\n" +
            "      \"searchInfo\": {\n" +
            "        \"textSnippet\": \"\\u003cb\\u003eAndroid\\u003c/b\\u003e allows your apps to do a lot! Imagine if someone released an app that \\u003cbr\\u003e\\nwent through the contact list and sent the entire list to a server somewhere for \\u003cbr\\u003e\\nmalicious purposes. This is why most of the functions that modify the user&#39;s \\u003cbr\\u003e\\ndevice or&nbsp;...\"\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    private QueryUtils() {
    }


    public static ArrayList<Objects> extractEarthquakes() {

        ArrayList<Objects> Onject11 = new ArrayList<>();


        try {

            JSONObject baseJsonResponce = new JSONObject(SAMPLE_JSON_RESPONSE);

            JSONArray earthArray = baseJsonResponce.getJSONArray("items");
            for (int i=0 ; i< earthArray.length() ; i++){
                JSONObject currentEarthqueak = earthArray.getJSONObject(i);
                JSONObject properties = currentEarthqueak.getJSONObject("volumeInfo");

                String Bookname = properties.getString("title");
                String authorname = properties.getString("publisher");
//                JSONObject forimage = properties.getJSONObject("imageLinks");
//                String image = forimage.getString("smallThumbnail");



                Objects oooo = new Objects(authorname,Bookname);
                Onject11.add(oooo);
            }


        } catch (JSONException e) {

            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

        return Onject11;
    }

}
