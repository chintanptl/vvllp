package com.chintan.training

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SmsActivity : AppCompatActivity() {

    lateinit var mSmsAdapter: SmsAdapter
    lateinit var mSmsLayout: RecyclerView.LayoutManager
    lateinit var mRVSms: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)

        mRVSms = findViewById(R.id.mRVSms)

        val mSmsList: ArrayList<String> = arrayListOf()

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

        if (mGetCustomerId != null) {
            mSmsList.add("To get Customer Id")
        }
        if (mSmsBalanceEnq != null) {
            mSmsList.add("Balance Enquiry")
        }
        if (mSmsLastTransaction != null) {
            mSmsList.add("Last Transactions")
        }
        if (mNearestAtm != null) {
            mSmsList.add("To locate the nearest ATM")
        }
        if (mRegisterEStatement != null) {
            mSmsList.add("To Register for E-Statement")
        }
        if (mGetChequeBook != null) {
            mSmsList.add("To Get a Cheque Book")
        }
        if (mChequeBookStatus != null) {
            mSmsList.add("Cheque Status")
        }
        if (mLinkAadhaarWithBank != null) {
            mSmsList.add("To link Aaadhar no.")
        }
        if (mUpdateEmail != null) {
            mSmsList.add("To Update Email")
        }
        if (mUpdatePan != null) {
            mSmsList.add("To Update PAN No.")
        }

        mSmsLayout = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mSmsAdapter = SmsAdapter(this, mSmsList, object : SmsAdapter.ClickListener {
            override fun onItemClick(position: String) {
                when (position) {
                    "To get Customer Id" -> {
                        sendData(mSmsNumber, "mGetCustomerId", mGetCustomerId)
                        Log.e("TAG", "onItemClick: 1" )
                    }
                    "Balance Enquiry" -> {
                        sendData(mSmsNumber, "mSmsBalanceEnq", mSmsBalanceEnq)
                        Log.e("TAG", "onItemClick: 2" )
                    }
                    "Last Transactions" -> {
                        sendData(mSmsNumber, "mSmsLastTransaction", mSmsLastTransaction)
                        Log.e("TAG", "onItemClick: 3" )
                    }
                    "To locate the nearest ATM" -> {
                        sendData(mSmsNumber, "mNearestAtm", mNearestAtm)
                        Log.e("TAG", "onItemClick: 4" )
                    }
                    "To Register for E-Statement" -> {
                        sendData(mSmsNumber, "mRegisterEStatement", mRegisterEStatement)
                        Log.e("TAG", "onItemClick: 5" )
                    }
                    "To Get a Cheque Book" -> {
                        sendData(mSmsNumber, "mGetChequeBook", mGetChequeBook)
                        Log.e("TAG", "onItemClick: 6" )
                    }
                    "Cheque Status" -> {
                        sendData(mSmsNumber, "mChequeBookStatus", mChequeBookStatus)
                        Log.e("TAG", "onItemClick: 7" )
                    }
                    "To link Aaadhar no." -> {
                        sendData(mSmsNumber, "mLinkAadhaarWithBank", mLinkAadhaarWithBank)
                        Log.e("TAG", "onItemClick: 8" )
                    }
                    "To Update Email" -> {
                        sendData(mSmsNumber, "mUpdateEmail", mUpdateEmail)
                        Log.e("TAG", "onItemClick: 9" )
                    }
                    "To Update PAN No." -> {
                        sendData(mSmsNumber, "mUpdatePan", mUpdatePan)
                        Log.e("TAG", "onItemClick: 10" )
                    }
                }
            }
        })
        mRVSms.layoutManager = mSmsLayout
        mRVSms.adapter = mSmsAdapter
    }

    fun sendData(num: String?, sms: String?, smsValue: String?) {
        val intent = Intent(this@SmsActivity, SendSmsActivity::class.java)
        intent.putExtra("mBankSmsNumber", num)
        intent.putExtra("$sms", smsValue)
        startActivity(intent)
    }
}