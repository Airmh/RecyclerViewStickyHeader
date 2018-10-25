package com.airmh.stickyheaderitems

import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

class RxSubjectHelper private constructor() {

    private object Instance { val INSTANCE = RxSubjectHelper() }
    private val publishSubject : Subject<Any> by lazy {
        PublishSubject.create<Any>()
    }

    companion object {
        val instance : RxSubjectHelper by lazy { Instance.INSTANCE }
    }

    fun subscribeSubject(consumer : Consumer<Any>): Disposable = publishSubject.subscribe(consumer)
    fun publishSubject(obj : Any) = publishSubject.onNext(obj)

}