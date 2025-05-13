.
├── etc
│   ├── rf
│   └── rp
├── LICENSE
├── meta
│   ├── BUILD_INSTRUCTUONS.md
│   ├── CODING_STANDARDS.md
│   ├── CONTRIBUTORS.md
│   └── PROJECT_STRUCTURE.md
├── pkg
│   ├── array
│   │   └── array.pics
│   ├── color
│   │   └── color.pics
│   ├── gfx
│   │   ├── color.pics
│   │   ├── image.pics
│   │   └── shapes.pics
│   ├── io
│   │   └── io.pics
│   ├── math
│   │   └── math.pics
│   ├── number
│   ├── res
│   │   └── resource.pics
│   ├── string
│   │   └── string.pics
│   └── tuple
│       └── tuple.pics
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   ├── antlr4
│   │   │   └── PiccodeScript.g4
│   │   ├── java
│   │   │   └── org
│   │   │       ├── editor
│   │   │       │   ├── AccessFrame.java
│   │   │       │   ├── CanvasFrame.java
│   │   │       │   ├── CodeEditor.java
│   │   │       │   ├── dialogs
│   │   │       │   │   └── AboutDialog.java
│   │   │       │   ├── EditorWindow.java
│   │   │       │   ├── errors
│   │   │       │   │   ├── EditorParser.java
│   │   │       │   │   └── IDEErrorListener.java
│   │   │       │   ├── events
│   │   │       │   │   ├── AccessEvents.java
│   │   │       │   │   ├── Actions.java
│   │   │       │   │   ├── AppAction.java
│   │   │       │   │   └── MenuEvents.java
│   │   │       │   ├── icons
│   │   │       │   │   ├── Icons.java
│   │   │       │   │   └── ImageLoader.java
│   │   │       │   ├── menu
│   │   │       │   │   └── Menus.java
│   │   │       │   ├── panels
│   │   │       │   │   ├── AboutPanel.form
│   │   │       │   │   ├── AboutPanel.java
│   │   │       │   │   ├── DashboardPanel.form
│   │   │       │   │   └── DashboardPanel.java
│   │   │       │   ├── SearchInput.java
│   │   │       │   ├── splash
│   │   │       │   └── util
│   │   │       │       └── It.java
│   │   │       └── piccode
│   │   │           ├── antlr4
│   │   │           │   ├── PiccodeScriptBaseListener.java
│   │   │           │   ├── PiccodeScriptBaseVisitor.java
│   │   │           │   ├── PiccodeScript.interp
│   │   │           │   ├── PiccodeScriptLexer.interp
│   │   │           │   ├── PiccodeScriptLexer.java
│   │   │           │   ├── PiccodeScriptLexer.tokens
│   │   │           │   ├── PiccodeScriptListener.java
│   │   │           │   ├── PiccodeScriptParser.java
│   │   │           │   ├── PiccodeScript.tokens
│   │   │           │   └── PiccodeScriptVisitor.java
│   │   │           ├── ast
│   │   │           │   ├── Arg.java
│   │   │           │   ├── ArrayAst.java
│   │   │           │   ├── Ast.java
│   │   │           │   ├── BinOpAst.java
│   │   │           │   ├── CallAst.java
│   │   │           │   ├── ClosureAst.java
│   │   │           │   ├── DoExprAst.java
│   │   │           │   ├── DotOperationAst.java
│   │   │           │   ├── FunctionAst.java
│   │   │           │   ├── IdentifierAst.java
│   │   │           │   ├── IfExpression.java
│   │   │           │   ├── ImportAst.java
│   │   │           │   ├── ListConstAst.java
│   │   │           │   ├── ModuleAst.java
│   │   │           │   ├── NamedCallArg.java
│   │   │           │   ├── NumberAst.java
│   │   │           │   ├── ObjectAst.java
│   │   │           │   ├── PiccodeVisitor.java
│   │   │           │   ├── PipeAst.java
│   │   │           │   ├── StatementList.java
│   │   │           │   ├── StringAst.java
│   │   │           │   ├── TupleAst.java
│   │   │           │   ├── UnaryAst.java
│   │   │           │   ├── UnitAst.java
│   │   │           │   ├── VarDecl.java
│   │   │           │   ├── WhenAst.java
│   │   │           │   └── WhenCase.java
│   │   │           ├── backend
│   │   │           │   └── Compiler.java
│   │   │           ├── piccode
│   │   │           │   └── Piccode.java
│   │   │           ├── rt
│   │   │           │   ├── Context.java
│   │   │           │   ├── Evaluator.java
│   │   │           │   ├── modules
│   │   │           │   │   ├── NativeFunctionFactory.java
│   │   │           │   │   ├── PiccodeArrayModule.java
│   │   │           │   │   ├── PiccodeColorModule.java
│   │   │           │   │   ├── PiccodeGfxModule.java
│   │   │           │   │   ├── PiccodeIOModule.java
│   │   │           │   │   ├── PiccodeMathModule.java
│   │   │           │   │   ├── PiccodeResourceModule.java
│   │   │           │   │   ├── PiccodeStringModule.java
│   │   │           │   │   └── PiccodeTupleModule.java
│   │   │           │   ├── NativeFunction.java
│   │   │           │   ├── PiccodeArray.java
│   │   │           │   ├── PiccodeBoolean.java
│   │   │           │   ├── PiccodeClosure.java
│   │   │           │   ├── PiccodeException.java
│   │   │           │   ├── PiccodeModule.java
│   │   │           │   ├── PiccodeNumber.java
│   │   │           │   ├── PiccodeObject.java
│   │   │           │   ├── PiccodeString.java
│   │   │           │   ├── PiccodeTuple.java
│   │   │           │   ├── PiccodeUnit.java
│   │   │           │   └── PiccodeValue.java
│   │   │           └── tokenmaker
│   │   │               └── PiccodeScriptTokenMaker.java
│   │   └── resources
│   │       ├── applogo
│   │       │   ├── appicon.png
│   │       │   └── dashboard.png
│   │       ├── icons
│   │       │   ├── about.png
│   │       │   ├── add-file.png
│   │       │   ├── add.png
│   │       │   ├── add-properties.png
│   │       │   ├── add-row.png
│   │       │   ├── appicon.png
│   │       │   ├── automatic.png
│   │       │   ├── bookmark.png
│   │       │   ├── book.png
│   │       │   ├── brush-fat.png
│   │       │   ├── brush.png
│   │       │   ├── cancel.png
│   │       │   ├── chatbot.png
│   │       │   ├── clear-symbol.png
│   │       │   ├── close.png
│   │       │   ├── code-file.png
│   │       │   ├── code-folder.png
│   │       │   ├── color.png
│   │       │   ├── compare-git.png
│   │       │   ├── copy-to-clipboard.png
│   │       │   ├── cut.png
│   │       │   ├── delete-document.png
│   │       │   ├── delete-file.png
│   │       │   ├── delete-folder.png
│   │       │   ├── delete-row.png
│   │       │   ├── delete-trash.png
│   │       │   ├── edit-file.png
│   │       │   ├── edit-property.png
│   │       │   ├── exit.png
│   │       │   ├── export.png
│   │       │   ├── file.png
│   │       │   ├── find-and-replace.png
│   │       │   ├── find.png
│   │       │   ├── folder.png
│   │       │   ├── folder-tree.png
│   │       │   ├── graph.png
│   │       │   ├── grid.png
│   │       │   ├── group-objects.png
│   │       │   ├── hot-article.png
│   │       │   ├── image-file.png
│   │       │   ├── layout.png
│   │       │   ├── license.png
│   │       │   ├── line.png
│   │       │   ├── logout.png
│   │       │   ├── navigation-toolbar-bottom.png
│   │       │   ├── navigation-toolbar-left.png
│   │       │   ├── navigation-toolbar-top.png
│   │       │   ├── new-window.png
│   │       │   ├── open-in-browser.png
│   │       │   ├── options.png
│   │       │   ├── paint-bucket.png
│   │       │   ├── paint-palette.png
│   │       │   ├── paint.png
│   │       │   ├── panorama.png
│   │       │   ├── paste.png
│   │       │   ├── pi.png
│   │       │   ├── plugin.png
│   │       │   ├── pointer.png
│   │       │   ├── point.png
│   │       │   ├── project-setup.png
│   │       │   ├── redo.png
│   │       │   ├── remove.png
│   │       │   ├── rename.png
│   │       │   ├── restore-page.png
│   │       │   ├── restore-window.png
│   │       │   ├── right-navigation-toolbar.png
│   │       │   ├── ruler.png
│   │       │   ├── run.png
│   │       │   ├── save-all.png
│   │       │   ├── save-as.png
│   │       │   ├── save-close.png
│   │       │   ├── save.png
│   │       │   ├── search.png
│   │       │   ├── select-all.png
│   │       │   ├── settings.png
│   │       │   ├── shortcut.png
│   │       │   ├── show-property.png
│   │       │   ├── sigma.png
│   │       │   ├── software-installer.png
│   │       │   ├── store.png
│   │       │   ├── system-task.png
│   │       │   ├── time-machine.png
│   │       │   ├── tools.png
│   │       │   ├── undo.png
│   │       │   ├── visual-effects.png
│   │       │   └── xxx-folder.png
│   │       └── misc
│   │           ├── misc.png
│   │           └── splash.png
│   └── test
│       └── java
└── tools
    └── SpriteSheetBuilder.java

44 directories, 192 files
