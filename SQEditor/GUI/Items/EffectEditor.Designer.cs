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
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(EffectEditor));
            this.label1 = new System.Windows.Forms.Label();
            this.tbDisplayText = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.btnSave = new System.Windows.Forms.Button();
            this.btnClose = new System.Windows.Forms.Button();
            this.labelRemainingChars = new System.Windows.Forms.Label();
            this.rbEquip = new System.Windows.Forms.RadioButton();
            this.rbUse = new System.Windows.Forms.RadioButton();
            this.label3 = new System.Windows.Forms.Label();
            this.flowLayoutPanel1 = new System.Windows.Forms.FlowLayoutPanel();
            this.tbScriptText = new System.Windows.Forms.RichTextBox();
            this.errorProvider = new System.Windows.Forms.ErrorProvider(this.components);
            this.flowLayoutPanel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.errorProvider)).BeginInit();
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
            this.tbDisplayText.Location = new System.Drawing.Point(102, 12);
            this.tbDisplayText.Name = "tbDisplayText";
            this.tbDisplayText.Size = new System.Drawing.Size(295, 20);
            this.tbDisplayText.TabIndex = 1;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 73);
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
            this.labelRemainingChars.BackColor = System.Drawing.SystemColors.Control;
            this.labelRemainingChars.ImageAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.labelRemainingChars.Location = new System.Drawing.Point(12, 86);
            this.labelRemainingChars.Name = "labelRemainingChars";
            this.labelRemainingChars.Size = new System.Drawing.Size(68, 23);
            this.labelRemainingChars.TabIndex = 6;
            this.labelRemainingChars.Text = "0 / 250";
            this.labelRemainingChars.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // rbEquip
            // 
            this.rbEquip.AutoSize = true;
            this.rbEquip.Checked = true;
            this.rbEquip.Location = new System.Drawing.Point(3, 3);
            this.rbEquip.Name = "rbEquip";
            this.rbEquip.Size = new System.Drawing.Size(52, 17);
            this.rbEquip.TabIndex = 7;
            this.rbEquip.TabStop = true;
            this.rbEquip.Text = "Equip";
            this.rbEquip.UseVisualStyleBackColor = true;
            // 
            // rbUse
            // 
            this.rbUse.AutoSize = true;
            this.rbUse.Location = new System.Drawing.Point(61, 3);
            this.rbUse.Name = "rbUse";
            this.rbUse.Size = new System.Drawing.Size(44, 17);
            this.rbUse.TabIndex = 8;
            this.rbUse.Text = "Use";
            this.rbUse.UseVisualStyleBackColor = true;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(12, 43);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(34, 13);
            this.label3.TabIndex = 9;
            this.label3.Text = "Type:";
            // 
            // flowLayoutPanel1
            // 
            this.flowLayoutPanel1.Controls.Add(this.rbEquip);
            this.flowLayoutPanel1.Controls.Add(this.rbUse);
            this.flowLayoutPanel1.Location = new System.Drawing.Point(102, 38);
            this.flowLayoutPanel1.Name = "flowLayoutPanel1";
            this.flowLayoutPanel1.Size = new System.Drawing.Size(111, 26);
            this.flowLayoutPanel1.TabIndex = 10;
            // 
            // tbScriptText
            // 
            this.tbScriptText.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.tbScriptText.Font = new System.Drawing.Font("Lucida Console", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tbScriptText.Location = new System.Drawing.Point(102, 70);
            this.tbScriptText.Name = "tbScriptText";
            this.tbScriptText.Size = new System.Drawing.Size(295, 136);
            this.tbScriptText.TabIndex = 11;
            this.tbScriptText.Text = "";
            this.tbScriptText.TextChanged += new System.EventHandler(this.tbScriptText_TextChanged);
            // 
            // errorProvider
            // 
            this.errorProvider.BlinkStyle = System.Windows.Forms.ErrorBlinkStyle.NeverBlink;
            this.errorProvider.ContainerControl = this;
            this.errorProvider.RightToLeft = true;
            // 
            // EffectEditor
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(409, 247);
            this.Controls.Add(this.labelRemainingChars);
            this.Controls.Add(this.tbScriptText);
            this.Controls.Add(this.flowLayoutPanel1);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.btnClose);
            this.Controls.Add(this.btnSave);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.tbDisplayText);
            this.Controls.Add(this.label1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.MinimumSize = new System.Drawing.Size(425, 285);
            this.Name = "EffectEditor";
            this.ShowInTaskbar = false;
            this.SizeGripStyle = System.Windows.Forms.SizeGripStyle.Hide;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "Effect Editor | StoneQuest";
            this.flowLayoutPanel1.ResumeLayout(false);
            this.flowLayoutPanel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.errorProvider)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox tbDisplayText;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button btnSave;
        private System.Windows.Forms.Button btnClose;
        private System.Windows.Forms.Label labelRemainingChars;
        private System.Windows.Forms.RadioButton rbEquip;
        private System.Windows.Forms.RadioButton rbUse;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.FlowLayoutPanel flowLayoutPanel1;
        private System.Windows.Forms.RichTextBox tbScriptText;
        private System.Windows.Forms.ErrorProvider errorProvider;
    }
}