namespace SQEditor.GUI.Items
{
    partial class EffectEditor
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null)) {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(EffectEditor));
            this.label1 = new System.Windows.Forms.Label();
            this.tbDisplayText = new System.Windows.Forms.TextBox();
            this.tbScriptText = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.btnSave = new System.Windows.Forms.Button();
            this.btnClose = new System.Windows.Forms.Button();
            this.labelRemainingChars = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 15);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(68, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Display Text:";
            // 
            // tbDisplayText
            // 
            this.tbDisplayText.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.tbDisplayText.Location = new System.Drawing.Point(86, 12);
            this.tbDisplayText.Name = "tbDisplayText";
            this.tbDisplayText.Size = new System.Drawing.Size(311, 20);
            this.tbDisplayText.TabIndex = 1;
            // 
            // tbScriptText
            // 
            this.tbScriptText.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.tbScriptText.Location = new System.Drawing.Point(86, 38);
            this.tbScriptText.MaxLength = 250;
            this.tbScriptText.Multiline = true;
            this.tbScriptText.Name = "tbScriptText";
            this.tbScriptText.Size = new System.Drawing.Size(311, 168);
            this.tbScriptText.TabIndex = 2;
            this.tbScriptText.KeyUp += new System.Windows.Forms.KeyEventHandler(this.tbScriptText_KeyUp);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 41);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(37, 13);
            this.label2.TabIndex = 3;
            this.label2.Text = "Script:";
            // 
            // btnSave
            // 
            this.btnSave.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.btnSave.Location = new System.Drawing.Point(322, 212);
            this.btnSave.Name = "btnSave";
            this.btnSave.Size = new System.Drawing.Size(75, 23);
            this.btnSave.TabIndex = 4;
            this.btnSave.Text = "Save";
            this.btnSave.UseVisualStyleBackColor = true;
            this.btnSave.Click += new System.EventHandler(this.btnSave_Click);
            // 
            // btnClose
            // 
            this.btnClose.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.btnClose.Location = new System.Drawing.Point(241, 212);
            this.btnClose.Name = "btnClose";
            this.btnClose.Size = new System.Drawing.Size(75, 23);
            this.btnClose.TabIndex = 5;
            this.btnClose.Text = "Close";
            this.btnClose.UseVisualStyleBackColor = true;
            this.btnClose.Click += new System.EventHandler(this.btnClose_Click);
            // 
            // labelRemainingChars
            // 
            this.labelRemainingChars.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.labelRemainingChars.BackColor = System.Drawing.Color.White;
            this.labelRemainingChars.ImageAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.labelRemainingChars.Location = new System.Drawing.Point(296, 182);
            this.labelRemainingChars.Name = "labelRemainingChars";
            this.labelRemainingChars.Size = new System.Drawing.Size(100, 23);
            this.labelRemainingChars.TabIndex = 6;
            this.labelRemainingChars.Text = "0 / 250";
            this.labelRemainingChars.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // EffectEditor
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(409, 247);
            this.Controls.Add(this.labelRemainingChars);
            this.Controls.Add(this.btnClose);
            this.Controls.Add(this.btnSave);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.tbScriptText);
            this.Controls.Add(this.tbDisplayText);
            this.Controls.Add(this.label1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MinimumSize = new System.Drawing.Size(425, 285);
            this.Name = "EffectEditor";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "EffectEditor";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox tbDisplayText;
        private System.Windows.Forms.TextBox tbScriptText;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button btnSave;
        private System.Windows.Forms.Button btnClose;
        private System.Windows.Forms.Label labelRemainingChars;
    }
}