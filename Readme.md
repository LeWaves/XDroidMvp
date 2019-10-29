# 轻量级的Android MVP快速开发框架

## 概述
主要会有这些特性：

**无需写`Contract`！ 无需写`Present`接口！  无需写`View`接口!**

新增：

* Mvp实现
* `RxJava` & `RxAndroid`
* 权限适配 `RxPermission`
* 事件订阅默认采用 `RxBus`
* 网络交互：
	* `Retrofit` + `rx`
	* `Https`
	* **统一异常处理**
	* 缓存
	* **支持多个baseUrl**
	* 。。。。
* 无需担心rx内存泄漏

保留：

* 提供`XActivity`、`XFragment`、`SimpleRecAdapter`、`SimpleListAdapter`等基类，可快速进行开发
* 完整封装`XRecyclerView`，可实现绝大部分需求
* `XStateController`、`XRecyclerContentLayout`实现loading、error、empty、content四种状态的自由切换
* 实现了`Memory`、`Disk`、`SharedPreferences`三种方式的缓存，可自由扩展
* 内置了`RxBus`，可自由切换到其他事件订阅库
* 内置`Glide`，可自由切换其他图片加载库
* 可输出漂亮的`Log`，支持`Json`、`Xml`、`Throwable`等，蝇量级实现
* 内置链式路由
* 内置常用工具类：`package`、`random`、`file`...,提供的都是非常常用的方法
* 内置加密工具类 `XCodec`，你想要的加密姿势都有


<p align="center">
	<img src="mvp.png"/>
</p>


**先睹为快**

你可以这么使用:

BasePagerFragment

```java
public abstract class BasePagerFragment extends XFragment<PBasePager>{

   @Override
    public void initData(Bundle savedInstanceState) {
        getP().loadData(getType(), 1);	//调用P方法
    }

   public void showData(int page, GankResults model) {
        if (page > 1) {
            getAdapter().addData(model.getResults());
        } else {
            getAdapter().setData(model.getResults());
        }

        contentLayout.getRecyclerView().setPage(page, MAX_PAGE);

        if (getAdapter().getItemCount() < 1) {
            contentLayout.showEmpty();
            return;
        }
    }
    
	 @Override
    public PBasePager newP() {
        return new PBasePager();
    }}
    
    @Override
    public int getLayoutId() {
        return R.layout.fragment_base_pager;
    }
```

PBasePager

```java
public class PBasePager extends XPresent<BasePagerFragment> {
    protected static final int PAGE_SIZE = 10;


    public void loadData(String type, final int page) {
        Api.getGankService().getGankData(type, PAGE_SIZE, page)
                .compose(XApi.<GankResults>getApiTransformer())
                .compose(XApi.<GankResults>getScheduler())
                .subscribe(new ApiSubcriber<GankResults>() {
                    @Override
                    protected void onFail(NetError error) {
                        getV().showError(error); //调用V方法
                    }

                    @Override
                    public void onNext(GankResults gankResults) {
                        getV().showData(page, gankResults);
                    }
                });
    }
}


### step1

将`mvp`作为依赖库，在您的app module 中 添加如下依赖:

compile project(':mvp')
```

### step2

拷贝`conf.gradle`到您的项目根目录，并修改项目gradle文件下引入：

apply from: "conf.gradle"
```

并添加:

```groovy
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

### step4

修改`XMVPConf`配置类，主要针对log、cache、router、imageloader。若采用默认配置，此步骤可略过.


## 重要说明

* [ButterKnife](https://github.com/JakeWharton/butterknife)使用的是8.4.0版本，重点是 `@BindView`，可以去项目官网查看。
* [Rxlifecycle](https://github.com/trello/RxLifecycle)使用的是1.0版本，具体如何使用可以查看官网。
* [RxPermissions](https://github.com/tbruyelle/RxPermissions)使用的是0.9.1版本，具体如何使用可以查看官网。
* [retrofit](https://github.com/square/retrofit)，具体如何使用可以查看官网。

## TODO

* [x] rx
* [x] retrofit
* [x] rxpermission
* [x] rxbus
* [x] cache
* [x] wiki


