package com.chintan.training

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SendSmsActivity : AppCompatActivity() {
    lateinit var mETSms:EditText
    lateinit var mBSend:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_sms)

        mETSms=findViewById(R.id.mETSms)
        mBSend=findViewById(R.id.mBSend)

        val mSmsNumber = intent.getStringExtra("mBankSmsNumber")
        val mGetCustomerId = intent.getStringExtra("mGetCustomerId")
        val mSmsBalanceEnq = intent.getStringExtra("mSmsBalanceEnq")
        val mSmsLastTransaction = intent.getStringExtra("mSmsLastTransaction")
        val mNearestAtm = intent.getStringExtra("mNearestAtm")
        val mRegisterEStatement = intent.getStringExtra("mRegisterEStatement")
        val mGetChequeBook = intent.getStringExtra("mGetChequeBook")
        val mChequeBookStatus = intent.getStringExtra("mChequeBookStatus")
        val mLinkAadhaarWithBank = intent.getStringExtra("mLinkAadhaarWithBank")
        val mUpdateEmail = intent.getStringExtra("mUpdateEmail")
        val mUpdatePan = intent.getStringExtra("mUpdatePan")

            if (mGetCustomerId!=null){
                mETSms.setText(mGetCustomerId)
                sendData(mSmsNumber,mGetCustomerId)
            }
            if (mSmsBalanceEnq!=null){
                mETSms.setText(mSmsBalanceEnq)
                sendData(mSmsNumber,mSmsBalanceEnq)
            }
            if (mSmsLastTransaction!=null){
                mETSms.setText(mSmsLastTransaction)
                sendData(mSmsNumber,mSmsLastTransaction)
            }
            if (mNearestAtm!=null){
                mETSms.setText(mNearestAtm)
                sendData(mSmsNumber,mNearestAtm)
            }
            if (mRegisterEStatement!=null){
                mETSms.setText(mRegisterEStatement)
                sendData(mSmsNumber,mRegisterEStatement)
            }
            if (mGetChequeBook!=null){
                mETSms.setText(mGetChequeBook)
                sendData(mSmsNumber,mGetChequeBook)
            }
            if (mChequeBookStatus!=null){
                mETSms.setText(mChequeBookStatus)
                sendData(mSmsNumber,mChequeBookStatus)
            }
            if (mLinkAadhaarWithBank!=null){
                mETSms.setText(mLinkAadhaarWithBank)
                sendData(mSmsNumber,mLinkAadhaarWithBank)
            }
            if (mUpdateEmail!=null){
                mETSms.setText(mUpdateEmail)
                sendData(mSmsNumber,mUpdateEmail)
            }
            if (mUpdatePan!=null){
                mETSms.setText(mUpdatePan)
                sendData(mSmsNumber,mUpdatePan)
            }
    }

    fun sendData(num:String,sms:String){
        mBSend.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("smsto:$num")
            intent.putExtra("sms_body", sms)
            startActivity(intent)
        }
    }
}