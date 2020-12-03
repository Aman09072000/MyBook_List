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
            "  \"totalItems\": 1973,\n" +
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
            "      \"id\": \"bYElAgAAQBAJ\",\n" +
            "      \"etag\": \"xtyt5Ymg8FI\",\n" +
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
            "        \"previewLink\": \"http://books.google.co.in/books?id=bYElAgAAQBAJ&printsec=frontcover&dq=android&hl=&cd=4&source=gbs_api\",\n" +
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
            "      \"etag\": \"W/xk0J1WGIM\",\n" +
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
            "        \"previewLink\": \"http://books.google.co.in/books?id=w8TsMgEACAAJ&dq=android&hl=&cd=5&source=gbs_api\",\n" +
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
                Objects oooo = new Objects(Bookname,authorname);
                Onject11.add(oooo);
            }


        } catch (JSONException e) {

            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

        return Onject11;
    }

}
