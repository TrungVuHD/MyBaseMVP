/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.trungvu.mvp.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.trungvu.mvp.data.network.model.BlogResponse;
import com.trungvu.mvp.data.network.model.OpenSourceResponse;
import com.trungvu.mvp.di.ActivityContext;
import com.trungvu.mvp.di.PerActivity;
import com.trungvu.mvp.ui.about.AboutMvpPresenter;
import com.trungvu.mvp.ui.about.AboutMvpView;
import com.trungvu.mvp.ui.about.AboutPresenter;
import com.trungvu.mvp.ui.feed.FeedMvpPresenter;
import com.trungvu.mvp.ui.feed.FeedMvpView;
import com.trungvu.mvp.ui.feed.FeedPagerAdapter;
import com.trungvu.mvp.ui.feed.FeedPresenter;
import com.trungvu.mvp.ui.feed.blogs.BlogAdapter;
import com.trungvu.mvp.ui.feed.blogs.BlogMvpPresenter;
import com.trungvu.mvp.ui.feed.blogs.BlogMvpView;
import com.trungvu.mvp.ui.feed.blogs.BlogPresenter;
import com.trungvu.mvp.ui.feed.opensource.OpenSourceAdapter;
import com.trungvu.mvp.ui.feed.opensource.OpenSourceMvpPresenter;
import com.trungvu.mvp.ui.feed.opensource.OpenSourceMvpView;
import com.trungvu.mvp.ui.feed.opensource.OpenSourcePresenter;
import com.trungvu.mvp.ui.login.LoginMvpPresenter;
import com.trungvu.mvp.ui.login.LoginMvpView;
import com.trungvu.mvp.ui.login.LoginPresenter;
import com.trungvu.mvp.ui.main.MainMvpPresenter;
import com.trungvu.mvp.ui.main.MainMvpView;
import com.trungvu.mvp.ui.main.MainPresenter;
import com.trungvu.mvp.ui.main.rating.RatingDialogMvpPresenter;
import com.trungvu.mvp.ui.main.rating.RatingDialogMvpView;
import com.trungvu.mvp.ui.main.rating.RatingDialogPresenter;
import com.trungvu.mvp.ui.splash.SplashMvpPresenter;
import com.trungvu.mvp.ui.splash.SplashMvpView;
import com.trungvu.mvp.ui.splash.SplashPresenter;
import com.trungvu.mvp.utils.rx.AppSchedulerProvider;
import com.trungvu.mvp.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    AboutMvpPresenter<AboutMvpView> provideAboutPresenter(
            AboutPresenter<AboutMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    RatingDialogMvpPresenter<RatingDialogMvpView> provideRateUsPresenter(
            RatingDialogPresenter<RatingDialogMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedMvpPresenter<FeedMvpView> provideFeedPresenter(
            FeedPresenter<FeedMvpView> presenter) {
        return presenter;
    }

    @Provides
    OpenSourceMvpPresenter<OpenSourceMvpView> provideOpenSourcePresenter(
            OpenSourcePresenter<OpenSourceMvpView> presenter) {
        return presenter;
    }

    @Provides
    BlogMvpPresenter<BlogMvpView> provideBlogMvpPresenter(
            BlogPresenter<BlogMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedPagerAdapter provideFeedPagerAdapter(AppCompatActivity activity) {
        return new FeedPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    OpenSourceAdapter provideOpenSourceAdapter() {
        return new OpenSourceAdapter(new ArrayList<OpenSourceResponse.Repo>());
    }

    @Provides
    BlogAdapter provideBlogAdapter() {
        return new BlogAdapter(new ArrayList<BlogResponse.Blog>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
