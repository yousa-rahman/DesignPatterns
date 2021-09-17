package com.company.behaviouralPattern.mediator;

public class ArticlesDialogBox extends DialogBox{
    ListBox articlesListBox = new ListBox(this);
    TextBox titleTextBox = new TextBox(this);
    Button saveButton = new Button(this);

    public void simulateUserInteraction(){
        articlesListBox.setSelection("Article 1");
        titleTextBox.setContent("");
        System.out.println("Text Box :" + titleTextBox.getContent());
        System.out.println("Save Button: " + saveButton.isEnabled());
    }


    @Override
    public void changed(UIControl control) {
        if(control == articlesListBox)
            articleSelected();
        else if(control == titleTextBox)
            titleChanged();

    }

    private void titleChanged(){
        String content = titleTextBox.getContent();
        boolean isEmpty = (content == null || content.isEmpty());
        saveButton.setEnabled(!isEmpty);
    }

    private void articleSelected(){
        titleTextBox.setContent(articlesListBox.getSelection());
        saveButton.setEnabled(true);
    }
}
