package com.chintan.training

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BankActivity : AppCompatActivity() {

    lateinit var mBankAdapter: BankAdapter
    lateinit var mBankLayout:LinearLayoutManager
    lateinit var mRVBank:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank)

        mRVBank = findViewById(R.id.mRVBank)

        val mBankList = arrayListOf<BankSmsModel>()
        val mBankArray = arrayOf<BankSmsModel>(
            BankSmsModel(
                "Axis",
                "9717000002",
                "CUSTID <account-number>",
                "BAL [account-number]",
                "MINI [account-number]",
                "ATM <Pincode>",
                "GREEN <Email Id>",
                "CHQBK <Last 6 digit of a/c No.>",
                "CHQST <6 digit of Cheque No.> <Last 6 digit of the A/c No.>",
                "Aadhaar < Aadhaar no.> AC < last 6 digit of AC no.>",
                "UPDATEM<valid Email ID>",
                "PAN <Pan number>  < Customer ID >"
            ),
            BankSmsModel(
                "BOB",
                "5616150",
                null,
                "BAL<space><last 4 digit of account number>",
                "MINI<space><last 4 digit of account number>",
                null,
                null,
                null,
                "CHEQ<space><last 4 digit of account number><space><chequeno.>",
                null,
                null,
                null
            )
        )



        mBankList.addAll(mBankArray)

        mBankLayout = LinearLayoutManager(this)
        mBankAdapter = BankAdapter(this, mBankList, object : BankAdapter.ClickListener {
            override fun onItemClick(position: Int) {
                val intent =Intent(this@BankActivity,SmsActivity::class.java)
                intent.putExtra("mBankSmsNumber",mBankList[position].mBankSmsNumber)
                intent.putExtra("mGetCustomerId",mBankList[position].mGetCustomerId)
                intent.putExtra("mSmsBalanceEnq",mBankList[position].mSmsBalanceEnq)
                intent.putExtra("mSmsLastTransaction",mBankList[position].mSmsLastTransaction)
                intent.putExtra("mNearestAtm",mBankList[position].mNearestAtm)
                intent.putExtra("mRegisterEStatement",mBankList[position].mRegisterEStatement)
                intent.putExtra("mGetChequeBook",mBankList[position].mGetChequeBook)
                intent.putExtra("mChequeBookStatus",mBankList[position].mChequeBookStatus)
                intent.putExtra("mLinkAadhaarWithBank",mBankList[position].mLinkAadhaarWithBank)
                intent.putExtra("mUpdateEmail",mBankList[position].mUpdateEmail)
                intent.putExtra("mUpdatePan",mBankList[position].mUpdatePan)
                startActivity(intent)
            }
        })
        mRVBank.layoutManager=mBankLayout
        mRVBank.adapter=mBankAdapter
    }
}