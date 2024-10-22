# WIP

欢迎各位大手子来加点东西或者指导一下网安怎么搞，直接放网上数据库会爆炸的。

- 目前理论上应该有的功能：
    - 加player，加match
    - 算平均分，算平均顺位
    - 算总马点且对此排序
- 希望有的功能：
  - 算和铳率
  - Natural-language-based 搜索， i.e. Frank今天做役满了么

- System Design:
  - 普通的Spring Web
  - 普通的MySQL
- 希望有的System Design:
  - Solr作为全文搜索提取自然语言关键信息做搜索/直接用LLM
  - 没必要用复杂的中间件，没这需求