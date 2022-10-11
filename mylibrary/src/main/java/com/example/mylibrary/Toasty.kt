package com.example.mylibrary

import android.content.Context
import android.widget.Toast

 object  Toasty {
      fun simpleToast(context: Context?, msg: String ){

        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

    }
}