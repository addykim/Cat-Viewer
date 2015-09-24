//package com.addyk.cat_viewer;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.drawable.BitmapDrawable;
//import android.os.Environment;
//import android.util.Log;
//import android.widget.ImageView;
//import android.widget.Toast;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//
//import com.squareup.picasso.UrlConnectionDownloader;
//
///**
// * Created by addy on 1/26/15.
// * This is intended to save images to the sd card.
// * Saved as a separate class to be reusable in other programs.
// */
//public class SaveFile {
//
//    private OutputStream output;
//    private static final String TAG = "SaveFile";
//
//    public SaveFile() {}
//
//    protected static void saveImage(String hashExt, ImageView imageView, Context context) {
//        if (CheckNetwork.isNetworkAvailable(context)) {
//            if (isExternalStorageReadable() && isExternalStorageWritable()) {
//                BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
//                Bitmap bitmap = drawable.getBitmap();
//                File filePath = Environment.getExternalStorageDirectory();
//                File image = new File(filePath, hashExt);
//                boolean success = false;
//                FileOutputStream outputStream;
//                try {
//                    outputStream = new FileOutputStream(image);
//                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
//
//                    outputStream.flush();
//                    outputStream.close();
//                    success = true;
//                    Toast.makeText(context, "Image saved", Toast.LENGTH_SHORT).show();
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            //http://stackoverflow.com/questions/27729976/download-and-save-images-using-picasso
//
//            //        final String fileName = mDataset.get(i).getAid() + ".jpg";
//            //        Target target = new Target() {
//            //
//            //            @Override
//            //            public void onPrepareLoad(Drawable arg0) {
//            //                return;
//            //            }
//            //
//            //            @Override
//            //            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom arg1) {
//            //
//            //                try {
//            //                    File file = null;
//            //
//            //                    // judge "imgs/.nomedia"'s existance to judge whether path available
//            //                    if(LightCache.testFileExist(GlobalConfig.getFirstStoragePath()
//            //                            + "imgs" + File.separator +".nomedia") == true)
//            //                        file = new File(GlobalConfig.getFirstStoragePath()
//            //                                + "imgs" + File.separator + fileName);
//            //
//            //                    else file = new File(GlobalConfig.getSecondStoragePath()
//            //                            + "imgs" + File.separator + fileName);
//            //
//            //                    file.createNewFile();
//            //                    FileOutputStream ostream = new FileOutputStream(file);
//            //                    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, ostream);
//            //                    ostream.close();
//            //
//            //                } catch (Exception e) {
//            //                    e.printStackTrace();
//            //                }
//            //            }
//            //
//            //            @Override
//            //            public void onBitmapFailed(Drawable arg0) {
//            //                return;
//            //            }
//            //        };
//            //
//            //        Picasso.with(GlobalConfig.getContext())
//            //                .load(Wenku8API.getCoverURL(mDataset.get(i).getAid()))
//            //                .into(target);
//        }
//    }
//
////    public static File getAlbumStorageDir(String albumName) {
////        // Get the directory for the user's public pictures directory.
////        File file = new File(Environment.getExternalStoragePublicDirectory(
////                Environment.DIRECTORY_PICTURES), albumName);
////        if (!file.mkdirs()) {
////            Log.e(TAG, "Directory not created");
////        }
////        return file;
////    }
//
//    /* Checks if external storage is available for read and write */
//    public static boolean isExternalStorageWritable() {
//        String state = Environment.getExternalStorageState();
//        if (Environment.MEDIA_MOUNTED.equals(state)) {
//            return true;
//        }
//        return false;
//    }
//
//    /* Checks if external storage is available to at least read */
//    public static boolean isExternalStorageReadable() {
//        String state = Environment.getExternalStorageState();
//        if (Environment.MEDIA_MOUNTED.equals(state) ||
//                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
//            return true;
//        }
//        return false;
//    }
//
//
//}