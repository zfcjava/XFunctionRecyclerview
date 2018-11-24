### 功能实现
* 多选的功能
* 插入标题
* 可折叠
### 计划安排

功能| 完成度
---|---
多选的功能 | 已完成
插入标题 | 待完成
可折叠| 待完成

### 多选功能
多选效果图如下：

![多选](https://github.com/zfcjava/XFunctionRecyclerview/blob/master/gif/mutiselect.gif)

#### 使用方法


```
    //1.获取RecyclerView的实例
    rcl_listview = findViewById(R.id.rcl_listview);
    //2.创建了adapter控制器（在控制器中提供了多选功能）
    xRclAdapterController = new XRclAdapterController<String,XRclViewHolder>(rcl_listview,R.layout.item){
            
        //4.该方法 使用方式 和 BaseQuickAdapter 使用一致
        @Override
        protected void convert(XRclViewHolder helper, String item) {
             helper.setText(R.id.tv_friend_name, item);
        }
        
        //该方法是 单击Item的回调
        @Override
        protected void onItemClick(BaseQuickAdapter adapter, View view, int position) {

         }
    };
    
    //5.开启多选功能
     xRclAdapterController.enbleMutilSelect(new XRclAdapterController.MutilSelectConfig() {
        
        //该方法提供给使用者，用来实现 被选中和未被选中的状态
        @Override
        public void
        onItemViewSelectStatusChanged(View itemView, boolean isSelected) {
            View view = itemView.findViewById(R.id.iv_check_btn);
            view.setVisibility(View.VISIBLE);
            view.setSelected(isSelected);
        }

        //该方法提供给使用者，用来实现选中数目和总数目的更新。
        @Override
        public void syncSelectNum(int seletNum, int total) {
            MutiSelectRclActivity.this.syncSelectNum(seletNum, total);
        }
    });
    
```

注意另外提供了获取当前选中所有数据集。数据集的数据结构由使用者定义（使用泛型技术）。

```
 List<T> selectedData = xRclAdapterController.getSelectedData();
```


