//    @RequestMapping("/simple")
//    public String Simple()
//    {
//        return "editor/simplepage";
//    }
//
//    @RequestMapping("/full")
//    public String Full()
//    {
//        return "editor/full";
//    }
//
//    @GetMapping("/login")
//    public String Login(ModelMap map,HttpServletRequest request)
//    {
//        Map<String,Integer> varmap= new HashMap<>();
//        varmap.put("rdm",new Random().nextInt(4));
//
//        HttpSession session = request.getSession();
//        session.setAttribute("testva","lalalala");
//
//        System.out.println(session.getId());
//
//        map.addAllAttributes(varmap);
//        return "login/index";
//    }
//
//    @PostMapping("/login")
//    @ResponseBody
//    public Object DoLogin(@RequestParam String username, @RequestParam String password, HttpServletRequest request)
//    {
//        System.out.println(username);
//        System.out.println(password);
//
//        System.out.println(request.getSession().getId());
//        System.out.println(request.getSession().getAttribute("testva"));
//
//        Map<String,String> map= new HashMap<>();
//        map.put("res","ok");
//
//        return map;
//    }
//
//    @RequestMapping("/{pathvar}")
//    public String PathVar(@PathVariable("pathvar") String pathvar)
//    {
//        return "editor/"+pathvar;
//    }
//
//    @RequestMapping("/home")
//    public String Home()
//    {
//        return "home/index";
//    }
//
//    @RequestMapping("testhome")
//    public String testhome()
//    {
//        return "home/test";
//    }

// function Save() {
//     var uid=/*[[${Mdc.uid}]]*/ '-1';
//     var title=/*[[${Mdc.title}]]*/ '';
//     var content =testEditor.getMarkdown();
//     $.ajax({
//         type:"POST",
//         dataType:"json",
//         url:"/savemd",
//         data:{
//             uid:uid,
//             content:content,
//             title:title
//         },
//         sucess:function (result) {
//             if(result!=null&&result.res=="ok")
//             {
//                 //alert(result.res);
//             }
//             else
//             {
//                 alert(result.msg);
//             }
//         }
//     });
//}