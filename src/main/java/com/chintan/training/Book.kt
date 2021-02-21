package com.chintan.training

data class Book(
    var mBookName: String,
    var mBookAuthor: String,
    var mBookPrice: String,
    var mBookRating: String,
    var mBookImage: String
)

data class BankSmsModel(
    var mBankName: String,
    var mBankSmsNumber: String?,
    var mGetCustomerId:String?,
    var mSmsBalanceEnq: String?,
    var mSmsLastTransaction: String?,
    var mNearestAtm:String?,
    var mRegisterEStatement:String?,
    var mGetChequeBook:String?,
    var mChequeBookStatus:String?,
    var mLinkAadhaarWithBank:String?,
    var mUpdateEmail:String?,
    var mUpdatePan:String?
)