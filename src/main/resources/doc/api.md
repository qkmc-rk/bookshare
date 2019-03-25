# api设计

## 1.只允许管理员操作的api

### 1.1书
- /book
    * GET 获取所有书籍
- /book/{id}
    * POST 修改某本书信息
    * DELETE 删除某本书
    * PUT 增加一本书
### 1.2用户
- /user GET 获取所有用户
- /user/{id}
    * GET 获取某个用户的信息
    * POST 修改某个用户的信息
- /user/{id}/lock 锁定用户
- /user/{id}/unlock 解锁用户 
### 1.3公告

- /notice/{id}
    * GET 获取某条公告
    * PUT 增加一条公告
    * DELETE 删除一条公告

## 2.匿名api
- /notice
    * GET 获取所有公告信息
- /book
    * GET 获取所有书籍信息 或者 按照分类查询书籍信息

## 3.注册用户
- /notice
- /book
    * GET 查询书籍、分类查询、查询自己的
    
- /comment/{bookid}
    * GET 获取某书籍的评论信息
    * PUT 进行评论
    
- /reply/{commentid}
    * GET 获取某评论的回复
    * POST 回复某评论
- /book/{id}
    * GET 获取某本书信息
    * PUT 发布一本书
    * POST 更改某本书的信息，只能更改自己的
    
- /order PUT 生成订单
- /order/{orderid} DELETE 删除订单
- /order GET 查看我的订单
- /order POST 确认订单